package com.rc.portal.webapp.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.util.StringUtils;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.app.framework.webapp.model.page.PageWraper;
import com.rc.commons.util.InfoUtil;
import com.rc.portal.service.CImageManager;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.vo.CImage;
import com.rc.portal.webapp.util.PageResult;

public class UploadImgAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	Condition model = new Condition();
	private final Long MAXSIZE=1024*1024*5L;//限制图片大小为5M
	private final String diskPath=InfoUtil.getInstance().getInfo("img", "images.public.image.leader.path");
	private CImageManager cimagemanager;
	private OpenSqlManage opensqlmanage;
	private PageWraper pw = new PageWraper();
	private PageResult rs = new PageResult();
	private CImage cimage;
	/**
	 * 删除
	 */
	public void del() throws Exception{
		String id = getRequest().getParameter("id");
		if(StringUtils.hasText(id)){
			this.getRequest().setCharacterEncoding("utf-8");
		    this.getResponse().setContentType("text/plain;charset=utf-8");
			PrintWriter out =  getResponse().getWriter();
			int n = cimagemanager.deleteByPrimaryKey(Integer.parseInt(id));
			out.print(n);
			out.close();
		}
	}
	public String goPage() throws ParseException{
		Map map = new HashMap();
		if(null!=model){
			if(null!=model.getStartDt() && null!=model.getEndDt() && !"".equals(model.getStartDt().trim()) && !"".equals(model.getEndDt().trim())){
				map.put("startDt", model.getStartDt());
				map.put("endDt", model.getEndDt());
			}
			if(null!=model.getImageName() && !"".equals(model.getImageName())){
				map.put("imageName", model.getImageName());
			}
			if(null!=model.getImageName() && !"".equals(model.getImageName())){
				map.put("imageName", model.getImageName());
			}
			if(null!=model.getImgType() && !"".equals(model.getImgType())&& !"0".equals(model.getImgType())&& 0!=model.getImgType()){
				map.put("imgType", model.getImgType());
			}
			rs.setP_pageSize(10);
			pw = opensqlmanage.selectForPageByMap(map, "c_image.countImages", "c_image.selectImages", rs.getP_curPage(), rs.getP_pageSize());
		}
		return "uploadPage";
	}
	
	/**
	 * 
	 * @throws Exception
	 * @throws SQLException
	 */
	public void uploadImage() throws IOException, SQLException{
		int flag =-1;
		String msg="图片上传出现异常";
		this.getRequest().setCharacterEncoding("utf-8");
	    this.getResponse().setContentType("text/plain;charset=utf-8");
		PrintWriter out = this.getResponse().getWriter();
		String basePath = this.getRequest().getSession().getServletContext().getRealPath("/");
		String filename = model.getImgfileFileName();
		String fileType= FilenameUtils.getExtension(filename);
		File file = model.getImgfile();
		if(checkFileType(fileType)){
			if(file.length()<MAXSIZE){
				String fullPath=diskPath+getDiskName()+"/"+DigestUtils.md5Hex(String.valueOf(System.currentTimeMillis()));
				String imgUrl=fullPath+"."+fileType;
				String fullName=basePath+imgUrl;
				File uploadFile = new File(fullName);
				FileUtils.copyFile(file, uploadFile);//上传图片
				CImage image = new CImage();
				image.setCreateDt(new Date());
				image.setImgurl(imgUrl);
				//image.setWeight(model.getWeight());
				image.setImgType(model.getImgType());
				image.setName(model.getImageName());
				//image.setStatus(0);
				image.setBak("位置管理");
				cimagemanager.insertSelective(image);
				flag=1;
				msg="图片上传成功";
			}else{
				flag =2;
				msg="上传图片大小超过5M";
			}
		}else{
			flag=0;
			msg="上传图片类型错误,暂支持jpg,png,gif,jpeg格式的图片";
		}
		Map map = new HashMap();
		map.put("flag", flag);
		map.put("msg", msg);
		out.write(JSONObject.fromObject(map).toString());
		out.close();
	}
	/**
	 * 检查文件类型
	 * @param type
	 * @return
	 */
	public boolean checkFileType(String type){
		boolean flag=false;
		type = type.toLowerCase();
		String[] arrType={"jpg","png","gif","jpeg"};
		for(String s:arrType){
			if(type.equals(s)){
				return true;
			}
		}
		return flag;
	}
	public static String getDiskName(){
		String diskname="";
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		diskname =df.format(new Date());
		return diskname;
		
	}
public static void main(String[] args) {
	System.out.println(getDiskName());
}	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return this.model;
	}
	@Override
	public void setModel(Object o) {
		// TODO Auto-generated method stub
		this.model =(Condition) o;
	}
	public class Condition{
		private File imgfile;
		private String imgfileFileName;//文件名
		private String startDt;
		private String endDt;
		private String imageName;
		private Integer imgType = 0;
		private Integer weight = 0;
		
		public Integer getImgType() {
			return imgType;
		}
		public void setImgType(Integer imgType) {
			this.imgType = imgType;
		}
		public Integer getWeight() {
			return weight;
		}
		public void setWeight(Integer weight) {
			this.weight = weight;
		}
		public File getImgfile() {
			return imgfile;
		}
		public void setImgfile(File imgfile) {
			this.imgfile = imgfile;
		}
		public String getImgfileFileName() {
			return imgfileFileName;
		}
		public void setImgfileFileName(String imgfileFileName) {
			this.imgfileFileName = imgfileFileName;
		}
		public String getStartDt() {
			return startDt;
		}
		public void setStartDt(String startDt) {
			this.startDt = startDt;
		}
		public String getEndDt() {
			return endDt;
		}
		public void setEndDt(String endDt) {
			this.endDt = endDt;
		}
		public String getImageName() {
			return imageName;
		}
		public void setImageName(String imageName) {
			this.imageName = imageName;
		}
		
	}


	public CImageManager getCimagemanager() {
		return cimagemanager;
	}

	public void setCimagemanager(CImageManager cimagemanager) {
		this.cimagemanager = cimagemanager;
	}

	public PageWraper getPw() {
		return pw;
	}

	public void setPw(PageWraper pw) {
		this.pw = pw;
	}

	public PageResult getRs() {
		return rs;
	}

	public void setRs(PageResult rs) {
		this.rs = rs;
	}

	public CImage getCimage() {
		return cimage;
	}

	public void setCimage(CImage cimage) {
		this.cimage = cimage;
	}

	public OpenSqlManage getOpensqlmanage() {
		return opensqlmanage;
	}

	public void setOpensqlmanage(OpenSqlManage opensqlmanage) {
		this.opensqlmanage = opensqlmanage;
	}
	
}
