package com.rc.portal.webapp.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.commons.util.InfoUtil;
import com.rc.dst.client.util.ClientSubmit;
import com.rc.portal.jms.MessageSender;
import com.rc.portal.service.CLocationManager;
import com.rc.portal.service.TLeaderImageManager;
import com.rc.portal.service.TLeaderManager;
import com.rc.portal.service.TMemberManager;
import com.rc.portal.service.TSysParameterManager;
import com.rc.portal.util.SharePoster;
import com.rc.portal.util.cookieManager;
import com.rc.portal.vo.CLocation;
import com.rc.portal.vo.CLocationExample;
import com.rc.portal.vo.TLeader;
import com.rc.portal.vo.TLeaderExample;
import com.rc.portal.vo.TLeaderImage;
import com.rc.portal.vo.TLeaderImageExample;
import com.rc.portal.vo.TMember;
import com.rc.portal.webapp.util.QRCodeUtil;
import com.rc.portal.webapp.util.zxing.QRCodeZXingUtil;

/**
 * 健康领袖前台action
 * 
 * @author user00
 * @createTime 2015-8-31 下午5:50:03
 */
public class HealthLeaderAction extends BaseAction {

	private static final long serialVersionUID = 8629590925309040239L;

	/**
	 * 健康领袖service
	 */
	private TLeaderManager tleadermanager;

	private TMemberManager tmembermanager;
	
	private MessageSender topicMessageSender;


	public TSysParameterManager getTsysparametermanager() {
		return tsysparametermanager;
	}

	public void setTsysparametermanager(TSysParameterManager tsysparametermanager) {
		this.tsysparametermanager = tsysparametermanager;
	}

	public MessageSender getTopicMessageSender() {
		return topicMessageSender;
	}

	public void setTopicMessageSender(MessageSender topicMessageSender) {
		this.topicMessageSender = topicMessageSender;
	}

	private TLeaderImageManager tleaderimagemanager;
	private TSysParameterManager tsysparametermanager;

	/**
	 * 地区service
	 */
	private CLocationManager clocationmanager;

	private File headImage;// 头像
	private File leaderImage1;// 资质
	private File leaderImage2;// 资质
	private File leaderImage3;// 资质
	private File leaderImage4;// 资质
	private File leaderImage5;// 资质
	private File cardFirst;// 身份证
	private File cardTwo;// 身份证反面
	private String headImageFileName;// 头像
	private String leaderImage1FileName;// 资质
	private String leaderImage2FileName;// 资质
	private String leaderImage3FileName;// 资质
	private String leaderImage4FileName;// 资质
	private String leaderImage5FileName;// 资质
	private String cardFirstFileName;// 身份证
	private String cardTwoFileName;// 身份证反面
	// 图片路径
	private final String diskPath = InfoUtil.getInstance().getInfo("img", "images.public.image.leader.path");

	// 二维码路径
	private final String qrCodeDiskPath = InfoUtil.getInstance()
			.getInfo("img", "images.public.image.leaderQRCode.path");

	// 二维码路径
	private final String qrLogoPath = InfoUtil.getInstance().getInfo("img", "qr.image.log.path");

	private final String sharedLeaderUrl = InfoUtil.getInstance().getInfo("config", "shareLeaderUrl");
	private final String leaderUrl = InfoUtil.getInstance().getInfo("config", "leaderUrl");

	// 图片链接地址前缀;
	private final String uiHttp = InfoUtil.getInstance().getInfo("healthleader", "healthleader.haibao.ui.http");;
	// 默认头像
	private final String defaultHead = InfoUtil.getInstance().getInfo("healthleader",
			"healthleader.haibao.default.head");;
	// 默认二维码
	private final String defaultQr = InfoUtil.getInstance().getInfo("healthleader",
			"healthleader.haibao.default.qrcode");;
	// 默认背景图
	private final String defaultBackground = InfoUtil.getInstance().getInfo("healthleader",
			"healthleader.haibao.background.img");;
	// 海报存储地址
	private final String savePath = InfoUtil.getInstance().getInfo("healthleader", "healthleader.haibao.save.path");;

	// 最新二维码图片
	private final String codeQR = InfoUtil.getInstance().getInfo("healthleader", "healthleader.qr.code");

	// 去海报页面
	private final String goHaibaoUrl = InfoUtil.getInstance().getInfo("healthleader", "healthleader.qr.code.gohaibao");

	
	
	private final String secoundQR = InfoUtil.getInstance().getInfo("healthleader", "healthleader.secound.qr");


	
	
	/**
	 * 跳转申请健康领袖页面
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String applyHealthLeaderPage() throws SQLException {
		TMember tMember = (TMember) this.getSession().getAttribute("member");
		if (tMember == null) {
			// FIXME WWF 未登录,跳转错误页面
			return ERROR;
		}

		if (tMember.getId() != null && tMember.getId() > 0) {
			TLeaderExample tLeaderExample = new TLeaderExample();
			tLeaderExample.createCriteria().andMemberIdEqualTo(tMember.getId());
			List<TLeader> list = tleadermanager.selectByExample(tLeaderExample);
			if (list != null && list.size() > 0) {
				return "health_leader";
			}
		}
		CLocationExample cLocationExample = new CLocationExample();
		cLocationExample.createCriteria().andGradeEqualTo(1);
		List<CLocation> firstList = clocationmanager.selectByExample(cLocationExample);
		this.getRequest().setAttribute("firstList", firstList);
		return "apply_health_leader_page";
	}

	/**
	 * 去修改页面
	 * 
	 * @return
	 * @throws SQLException
	 * @throws NumberFormatException
	 */
	public String editHealthLeaderPage() throws NumberFormatException, SQLException {
		String id = this.getRequest().getParameter("id");
		if (id == null || "".equals(id)) {
			return "error_page";
		}
		TMember tMember = (TMember) this.getSession().getAttribute("member");
		if (tMember == null) {
			return ERROR;
		}
		TLeader tLeader = tleadermanager.selectByPrimaryKey(Long.valueOf(id));
		if (tLeader == null) {
			return "error_page";
		} else if (tLeader.getMemberId().longValue() != tMember.getId().longValue()) {
			return "error_page";
		}
		this.getRequest().setAttribute("tLeader", tLeader);
		if (tLeader.getAuditType() == 1) {// 存在,并审核通过
			// 跳转领秀中心页面
			return "health_leader";
		}
		TLeaderImageExample tLeaderImageExample = new TLeaderImageExample();
		tLeaderImageExample.createCriteria().andLeaderIdEqualTo(tLeader.getId());
		List<TLeaderImage> imageList = tleaderimagemanager.selectByExample(tLeaderImageExample);
		if (imageList != null && imageList.size() > 0) {
			this.getRequest().setAttribute("leaderImage1", imageList.get(0));
		}
		if (imageList != null && imageList.size() > 1) {
			this.getRequest().setAttribute("leaderImage2", imageList.get(1));
		}
		if (imageList != null && imageList.size() > 2) {
			this.getRequest().setAttribute("leaderImage3", imageList.get(2));
		}
		if (imageList != null && imageList.size() > 3) {
			this.getRequest().setAttribute("leaderImage4", imageList.get(3));
		}
		if (imageList != null && imageList.size() > 4) {
			this.getRequest().setAttribute("leaderImage5", imageList.get(4));
		}
		CLocationExample cLocationExample = new CLocationExample();
		cLocationExample.createCriteria().andGradeEqualTo(1);
		List<CLocation> firstList = clocationmanager.selectByExample(cLocationExample);
		CLocation thirdLocation = clocationmanager.selectByPrimaryKey(tLeader.getAreaId().intValue());
		this.getRequest().setAttribute("firstList", firstList);
		System.out.println("第三层:\t" + (thirdLocation == null ? "" : thirdLocation.getName()));
		System.out.println("第一层List:\t" + firstList);
		this.getRequest().setAttribute("thirdLocation", thirdLocation);
		if (thirdLocation != null) {
			CLocation secondLocation = clocationmanager.selectByPrimaryKey(thirdLocation.getParentid().intValue());
			List<CLocation> thirdList = clocationmanager.selectAllChildrenByParendId(secondLocation.getId());
			this.getRequest().setAttribute("secondLocation", secondLocation);
			this.getRequest().setAttribute("thirdList", thirdList);
			System.out.println("第二层:\t" + (secondLocation == null ? "" : secondLocation.getName()));
			System.out.println("第三层List:\t" + (thirdList == null ? "" : thirdList));
			if (secondLocation != null) {
				CLocation firstLocation = clocationmanager.selectByPrimaryKey(secondLocation.getParentid().intValue());
				this.getRequest().setAttribute("firstLocation", firstLocation);
				System.out.println("第一层:\t" + (firstLocation == null ? "" : firstLocation.getName()));
				List<CLocation> secondList = clocationmanager.selectAllChildrenByParendId(firstLocation.getId());
				System.out.println("第二层List:\t" + secondList);
				this.getRequest().setAttribute("secondList", secondList);
			}
		}
		return "edit_health_leader_page";
	}

	/**
	 * 根据省查市,市查区,区查县
	 * 
	 * @throws SQLException
	 * @throws NumberFormatException
	 */
	public void selectLocationByParentId() throws NumberFormatException, SQLException {
		String id = this.getRequest().getParameter("id");
		// CLocation clocation =
		// clocationmanager.selectByPrimaryKey(Integer.valueOf(id));
		CLocationExample cLocationExample = new CLocationExample();
		cLocationExample.createCriteria().andParentidEqualTo(Integer.valueOf(id));
		List<CLocation> list = clocationmanager.selectByExample(cLocationExample);
		this.writeObjectToResponse(list, ContentType.application_json);
	}

	/**
	 * 保存健康领袖
	 * 
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	public String saveHealthLeader() throws IOException, SQLException {
		String id = this.getRequest().getParameter("id");
		String realName = this.getRequest().getParameter("realName");
		String nickName = this.getRequest().getParameter("nickName");
		String sex = this.getRequest().getParameter("sex");
		String cardCode = this.getRequest().getParameter("cardCode");
		String thirdLocation = this.getRequest().getParameter("thirdLocation");
		String address = this.getRequest().getParameter("address");
		String phone = this.getRequest().getParameter("phone");
		TMember tMember = (TMember) this.getSession().getAttribute("member");
		if (tMember == null) {
			return ERROR;
		}
		Map<String, Object> map = uploadImage();
		TLeader tLeader = null;
		if (id != null && !"".equals(id)) {
			tLeader = tleadermanager.selectByPrimaryKey(Long.valueOf(id));
			if (tLeader == null) {
				tLeader = new TLeader();
			}
		} else {
			if (tMember.getId() != null && tMember.getId() > 0L) {
				TLeaderExample tLeaderExample = new TLeaderExample();
				tLeaderExample.createCriteria().andMemberIdEqualTo(tMember.getId());
				List<TLeader> llLeaders = tleadermanager.selectByExample(tLeaderExample);
				if (llLeaders == null || llLeaders.size() <= 0) {
					tLeader = new TLeader();
				} else {
					tLeader = llLeaders.get(0);
				}
			} else {
				tLeader = new TLeader();
			}
		}
		if (map != null && map.get("headImage") != null) {
			tLeader.setHeadUrl(map.get("headImage").toString());
		}
		if (map != null && map.get("cardFirst") != null) {
			tLeader.setCardFirstUrl(map.get("cardFirst").toString());
		}
		if (map != null && map.get("cardTwo") != null) {
			tLeader.setCardTwoUrl(map.get("cardTwo").toString());
		}
		if (realName != null && !"".equals(realName)) {
			tLeader.setRealName(realName);
		}
		if (nickName != null && !"".equals(nickName)) {
			tLeader.setNickName(nickName);
		}
		if (sex != null && !"".equals(sex)) {
			tLeader.setSex(Integer.valueOf(sex));
		}
		if (cardCode != null && !"".equals(cardCode)) {
			tLeader.setCardCode(cardCode);
		}
		if (thirdLocation != null && !"".equals(thirdLocation)) {
			tLeader.setAreaId(Long.valueOf(thirdLocation));
		}
		if (address != null && !"".equals(address)) {
			tLeader.setAddress(address);
		}
		if (phone != null && !"".equals(phone)) {
			tLeader.setPhone(phone);
		}
		tLeader.setAuditType(3);
		tLeader.setStatus(1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssms");
		String code = sdf.format(new Date()) + randomString();
		if (tLeader.getCode() == null || "".equals(tLeader.getCode())) {
			tLeader.setCode(code);
		}
		File qrCodeDir = new File(this.getRequest().getSession().getServletContext().getRealPath("/") + qrCodeDiskPath);
		File qrCodeFile = new File(this.getRequest().getSession().getServletContext().getRealPath("/") + qrCodeDiskPath
				+ code + ".jpg");
		if (!qrCodeDir.exists()) {
			qrCodeDir.mkdirs();
		}
		if (!qrCodeFile.exists()) {
			qrCodeFile.createNewFile();
		}
		FileOutputStream fileOutputStream = new FileOutputStream(qrCodeFile);
		// FIXME WWF 二维码链接地址待修改
		// boolean ret = QRCodeUtil.encoderQRCoder(sharedLeaderUrl + "?code=" +
		// code + "&hurl=" + leaderUrl,
		// fileOutputStream, 10);
		String contentString = sharedLeaderUrl + "?code=" + code + "&hurl=" + leaderUrl;
		boolean ret = false;
		try {
			URL url = new URL(qrLogoPath);
			URLConnection uc = url.openConnection();
			uc.getInputStream();
			ret = QRCodeZXingUtil.encoderQRCoder_logoUrl(contentString, fileOutputStream, qrLogoPath);
		} catch (IOException e) {
			log.error("生成健康领袖logo二维码不存在,配置链接为:[" + qrLogoPath + "]");
			ret = QRCodeUtil.encoderQRCoder(contentString, fileOutputStream, 10);
		}
		// if (ret) {
		tLeader.setDimensionalCodeUrl(qrCodeDiskPath + code + ".jpg");
		// }
		fileOutputStream.flush();
		fileOutputStream.close();
		Long memberId = tMember.getId();
		tLeader.setMemberId(memberId);
		tLeader.setAuditType(3);
		Long leaderId = null;
		if (tLeader.getId() == null) {
			tLeader.setCreateDt(new Date());
			leaderId = tleadermanager.insertSelective(tLeader);
		} else {
			leaderId = tLeader.getId();
			tleadermanager.updateByPrimaryKeySelective(tLeader);
		}
		TLeaderImage tLeaderImage = null;
		for (int i = 1; i <= 5; i++) {
			if (map != null && map.get(String.valueOf(("leaderImage" + String.valueOf(i)))) != null) {
				tLeaderImage = new TLeaderImage();
				tLeaderImage.setImageUrl(map.get(String.valueOf(("leaderImage" + String.valueOf(i)))).toString());
				tLeaderImage.setLeaderId(leaderId);
				tleaderimagemanager.insertSelective(tLeaderImage);
			}
		}

		// 1:头像;2:二维码;3:昵称;
		createPosterImg(code + "_" + leaderId, tMember, qrCodeFile);
		
		generateLeaderSecoundQR(tLeader);
		// 销毁存入的手机验证码
		this.getSession().removeAttribute("apply_health_code_" + phone);
		cookieManager.addCookie(this.getRequest(), this.getResponse(), code, code, 999999999);
		return "apply_health_leader_success";
	}
	
	
	/**
	 * 生成第二个二维码,文章二维码
	 * @param tLeader
	 * @throws IOException
	 */
	private void generateLeaderSecoundQR(TLeader tLeader) throws IOException {
		// 生成第二个二维码
		if (tLeader.getCode() != null && !"".equals(tLeader.getCode())) {
			// savePath存海报的路径下
			File _savePath = new File(savePath);
			String realPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();// System.getProperty("user.dir");
			if (realPath.endsWith("/WEB-INF/classes/")) {
				realPath = realPath.substring(0, realPath.length() - 17);
			}
			File secoundQRFile = new File(realPath + savePath + tLeader.getId() + "_" + tLeader.getCode() + ".jpg");
			System.out.println("文章页二维码图片路径:\t\t"
					+ (realPath + savePath + tLeader.getId() + "_" + tLeader.getCode() + ".jpg"));
			if (!_savePath.exists()) {
				_savePath.mkdirs();
			}
			File realPathFile = new File(realPath + savePath);
			if (!realPathFile.exists()) {
				realPathFile.mkdirs();
			}
			if (!secoundQRFile.exists()) {
				secoundQRFile.createNewFile();
			}
			FileOutputStream fileOutputStream = new FileOutputStream(secoundQRFile);
			String content = secoundQR + tLeader.getCode() + "&hurl=" + java.net.URLEncoder.encode("/", "utf-8");
			try {
				URL url = new URL(qrLogoPath);
				URLConnection uc = url.openConnection();
				uc.getInputStream();
				QRCodeZXingUtil.encoderQRCoder_logoUrl(content, fileOutputStream, qrLogoPath);
			} catch (IOException e) {
				// log.error("生成健康领袖logo二维码不存在,配置链接为:[" + qrLogoPath + "]");
				QRCodeUtil.encoderQRCoder(content, fileOutputStream, 10);
			}
			fileOutputStream.flush();
			fileOutputStream.close();
		}

		// code对应的二维码,跳转海报的页面

		if (tLeader.getCode() != null && !"".equals(tLeader.getCode())) {
			String realPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();// System.getProperty("user.dir");
			if (realPath.endsWith("/WEB-INF/classes/")) {
				realPath = realPath.substring(0, realPath.length() - 17);
			}
			File codeQrDir = new File(realPath + codeQR);
			if (!codeQrDir.exists()) {
				codeQrDir.mkdirs();
			}
			File codeQRFile = new File(codeQrDir + "/" + tLeader.getCode() + ".jpg");
			if (!codeQRFile.exists()) {
				codeQRFile.createNewFile();
			}
			FileOutputStream fileOutputStream = new FileOutputStream(codeQRFile);
			System.out.println("最新二维码路径:\t\t" + codeQRFile.getAbsolutePath());

			String content = goHaibaoUrl + "?code=" + tLeader.getCode() + "&id=" + tLeader.getId();
			try {
				URL url = new URL(qrLogoPath);
				URLConnection uc = url.openConnection();
				uc.getInputStream();
				QRCodeZXingUtil.encoderQRCoder_logoUrl(content, fileOutputStream, qrLogoPath);
			} catch (IOException e) {
				// log.error("生成健康领袖logo二维码不存在,配置链接为:[" + qrLogoPath + "]");
				QRCodeUtil.encoderQRCoder(content, fileOutputStream, 10);
			}
			fileOutputStream.flush();
			fileOutputStream.close();
		}
	}


	/**
	 * 生成海报文件
	 */
	// public void createPosterImg(String httpHeadFile, String httpQRCodeFile,
	// String nickName, String httpBackImg) {
	private void createPosterImg(String backImgName, TMember tMember, File qrCodeFile) {
		String fontName = "宋体";
		int fontStyle = 10;
		int color = 0;
		int fontSize = 36;
		int x = 190;
		int y = 370;
		URL url = null;
		URLConnection connection = null;
		try {
			url = new URL(defaultBackground);
			connection = url.openConnection();
			connection.setDoOutput(true);
			BufferedImage image = ImageIO.read(connection.getInputStream());
			File _savePath = new File(this.getRequest().getSession().getServletContext().getRealPath("/") + savePath);
			File _saveFile = new File(this.getRequest().getSession().getServletContext().getRealPath("/") + savePath
					+ backImgName + ".jpg");
			if (!_savePath.exists()) {
				_savePath.mkdirs();
			}
			if (!_saveFile.exists()) {
				_saveFile.createNewFile();
			}

			FileOutputStream fout = new FileOutputStream(this.getRequest().getSession().getServletContext()
					.getRealPath("/")
					+ savePath + backImgName + ".jpg");
			ImageIO.write(image, "jpg", fout);
			fout.flush();
			fout.close();
		} catch (MalformedURLException e) {// http背景图片不存在
			log.error("海报背景图片不存在");
			e.printStackTrace();
		} catch (IOException e) {// http背景图片不存在
			log.error("海报背景图片不存在");
			e.printStackTrace();
		}
		String _backImgName = this.getRequest().getSession().getServletContext().getRealPath("/") + savePath
				+ backImgName + ".jpg";
		String httpHeadFile = "";
		if (tMember.getHeadPortrait() != null && !"".equals(tMember.getHeadPortrait())) {
			String getHeadPortrait = tMember.getHeadPortrait();
			if (getHeadPortrait.startsWith("http://")) {
				httpHeadFile = tMember.getHeadPortrait();// 头像
			} else {
				httpHeadFile = uiHttp + tMember.getHeadPortrait();// 头像
			}
			try {
				url = new URL(httpHeadFile);
				connection = url.openConnection();
				connection.setDoOutput(true);
				ImageIO.read(connection.getInputStream());
			} catch (MalformedURLException e) {
				e.printStackTrace();
				httpHeadFile = defaultHead;
			} catch (IOException e) {
				e.printStackTrace();
				httpHeadFile = defaultHead;
			}
		} else {
			httpHeadFile = defaultHead;
		}
		System.out.println("----------------------------------------------------------");
		System.out.println("背景图片:【" + _backImgName + "】");
		System.out.println("头像图片:【" + httpHeadFile + "】");
		System.out.println("二维码图片:【" + qrCodeFile.getAbsolutePath() + "】");
		String nickName = tMember.getNickName() == null ? tMember.getUserName() : tMember.getNickName();
		SharePoster.pressTextAndImg(httpHeadFile, qrCodeFile, nickName, _backImgName, fontName, fontStyle, color,
				fontSize, x, y);
	}

	/**
	 * 修改操作
	 * 
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	public String updateHealthLeader() throws IOException, SQLException {
		String id = this.getRequest().getParameter("id");
		String realName = this.getRequest().getParameter("realName");
		String nickName = this.getRequest().getParameter("nickName");
		String sex = this.getRequest().getParameter("sex");
		String cardCode = this.getRequest().getParameter("cardCode");
		String thirdLocation = this.getRequest().getParameter("thirdLocation");
		String address = this.getRequest().getParameter("address");
		String phone = this.getRequest().getParameter("phone");
		TMember tMember = (TMember) this.getSession().getAttribute("member");
		// String verifyCode = this.getRequest().getParameter("verifyCode");
		// if (id == null && (headImageFileName == null ||
		// "".equals(headImageFileName.trim()))) {
		// return ERROR;
		// }
		// if (id == null
		// && ((leaderImage1FileName == null ||
		// "".equals(leaderImage1FileName.trim()))
		// && (leaderImage2FileName == null ||
		// "".equals(leaderImage2FileName.trim()))
		// && (leaderImage3FileName == null ||
		// "".equals(leaderImage3FileName.trim()))
		// && (leaderImage4FileName == null ||
		// "".equals(leaderImage4FileName.trim())) && (leaderImage5FileName ==
		// null || ""
		// .equals(leaderImage5FileName.trim())))) {
		// // 资质不能为空;
		// return ERROR;
		// }
		// if (id == null && (cardFirstFileName == null ||
		// "".equals(cardFirstFileName.trim()))) {
		// return ERROR;
		// }
		// if (id == null && (cardTwoFileName == null ||
		// "".equals(cardTwoFileName.trim()))) {
		// return ERROR;
		// }
		Map<String, Object> map = uploadImage();
		TLeader tLeader = null;
		if (id != null && !"".equals(id)) {
			tLeader = tleadermanager.selectByPrimaryKey(Long.valueOf(id));
			if (tLeader == null) {
				tLeader = new TLeader();
			}
		} else {
			tLeader = new TLeader();
		}
		if (map != null && map.get("headImage") != null) {
			tLeader.setHeadUrl(map.get("headImage").toString());
		}
		if (map != null && map.get("cardFirst") != null) {
			tLeader.setCardFirstUrl(map.get("cardFirst").toString());
		}
		if (map != null && map.get("cardTwo") != null) {
			tLeader.setCardTwoUrl(map.get("cardTwo").toString());
		}
		if (realName != null && !"".equals(realName)) {
			tLeader.setRealName(realName);
		}
		if (nickName != null && !"".equals(nickName)) {
			tLeader.setNickName(nickName);
		}
		if (sex != null && !"".equals(sex)) {
			tLeader.setSex(Integer.valueOf(sex));
		}
		if (cardCode != null && !"".equals(cardCode)) {
			tLeader.setCardCode(cardCode);
		}
		if (thirdLocation != null && !"".equals(thirdLocation)) {
			tLeader.setAreaId(Long.valueOf(thirdLocation));
		}
		if (address != null && !"".equals(address)) {
			tLeader.setAddress(address);
		}
		if (phone != null && !"".equals(phone)) {
			tLeader.setPhone(phone);
		}
		tLeader.setAuditType(0);
		tLeader.setStatus(1);
		if (tLeader.getCode() == null || "".equals(tLeader.getCode())) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssms");
			tLeader.setCode(sdf.format(new Date()) + randomString());
		}
		Long leaderId = null;
		if (tLeader.getId() == null) {
			tLeader.setCreateDt(new Date());
			tLeader.setAuditType(0);
			leaderId = tleadermanager.insertSelective(tLeader);
		} else {
			leaderId = tLeader.getId();
			tleadermanager.updateByPrimaryKeySelective(tLeader);
		}
		TLeaderImage tLeaderImage = null;
		for (int i = 1; i <= 5; i++) {
			if (map != null && map.get(String.valueOf(("leaderImage" + String.valueOf(i)))) != null) {
				String imgId = this.getRequest().getParameter("leaderImage" + String.valueOf(i) + "Id");
				if (imgId == null || "".equals(imgId)) {
					tLeaderImage = new TLeaderImage();
					tLeaderImage.setImageUrl(map.get(String.valueOf(("leaderImage" + String.valueOf(i)))).toString());
					tLeaderImage.setLeaderId(leaderId);
					tleaderimagemanager.insertSelective(tLeaderImage);
				} else {
					tLeaderImage = tleaderimagemanager.selectByPrimaryKey(Long.valueOf(imgId));
					if (tLeaderImage == null) {
						tLeaderImage = new TLeaderImage();
					}
					tLeaderImage.setImageUrl(map.get(String.valueOf(("leaderImage" + String.valueOf(i)))).toString());
					tLeaderImage.setLeaderId(leaderId);
					if (tLeaderImage.getId() == null) {
						tleaderimagemanager.insertSelective(tLeaderImage);
					} else {
						tleaderimagemanager.updateByPrimaryKeySelective(tLeaderImage);
					}
				}
			}
		}
		// 销毁存入的手机验证码
		this.getSession().removeAttribute("apply_health_code_" + phone);

		return "apply_health_leader_success";
	}

	/**
	 * 上传图片,保存路径
	 * 
	 * @return
	 * @throws IOException
	 */
	private Map<String, Object> uploadImage() throws IOException {
		Map<String, Object> fileMap = new HashMap<String, Object>();
		this.getRequest().setCharacterEncoding("utf-8");
		this.getResponse().setContentType("text/plain;charset=utf-8");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssms");
		String _subFilePath = sdf.format(new Date());
		File folderFile = new File(this.getRequest().getSession().getServletContext().getRealPath("/") + diskPath
				+ _subFilePath);
		if (!folderFile.exists()) {
			folderFile.mkdirs();
		}
		if (headImage != null && headImage.exists()) {
			String newFileName = randomFileName(headImageFileName);
			String headPath = folderFile + "/" + newFileName;
			File _image1 = new File(headPath);
			if (!_image1.exists()) {
				_image1.createNewFile();
			}
			FileUtils.copyFile(headImage, _image1);
			fileMap.put("headImage", diskPath + _subFilePath + "/" + newFileName);
		}
		if (leaderImage1 != null && leaderImage1.exists()) {
			String newFileName = randomFileName(leaderImage1FileName);
			String filePath1 = folderFile + "/" + newFileName;
			File _image1 = new File(filePath1);
			if (!_image1.exists()) {
				_image1.createNewFile();
			}
			FileUtils.copyFile(leaderImage1, _image1);
			fileMap.put("leaderImage1", diskPath + _subFilePath + "/" + newFileName);
		}
		if (leaderImage2 != null && leaderImage2.exists()) {
			String newFileName = randomFileName(leaderImage2FileName);
			String filePath2 = folderFile + "/" + newFileName;
			File _image2 = new File(filePath2);
			if (!_image2.exists()) {
				_image2.createNewFile();
			}
			FileUtils.copyFile(leaderImage2, _image2);
			fileMap.put("leaderImage2", diskPath + _subFilePath + "/" + newFileName);
		}
		if (leaderImage3 != null && leaderImage3.exists()) {
			String newFileName = randomFileName(leaderImage3FileName);
			String filePath3 = folderFile + "/" + newFileName;
			File _image3 = new File(filePath3);
			if (!_image3.exists()) {
				_image3.createNewFile();
			}
			FileUtils.copyFile(leaderImage3, _image3);
			fileMap.put("leaderImage3", diskPath + _subFilePath + "/" + newFileName);
		}
		if (leaderImage4 != null && leaderImage4.exists()) {
			String newFileName = randomFileName(leaderImage4FileName);
			String filePath4 = folderFile + "/" + newFileName;
			File _image4 = new File(filePath4);
			if (!_image4.exists()) {
				_image4.createNewFile();
			}
			FileUtils.copyFile(leaderImage4, _image4);
			fileMap.put("leaderImage4", diskPath + _subFilePath + "/" + newFileName);
		}
		if (leaderImage5 != null && leaderImage5.exists()) {
			String newFileName = randomFileName(leaderImage5FileName);
			String filePath5 = folderFile + "/" + newFileName;
			File _image5 = new File(filePath5);
			if (!_image5.exists()) {
				_image5.createNewFile();
			}
			FileUtils.copyFile(leaderImage5, _image5);
			fileMap.put("leaderImage5", diskPath + _subFilePath + "/" + newFileName);
		}
		if (cardFirst != null && cardFirst.exists()) {
			String newFileName = randomFileName(cardFirstFileName);
			String cardFirstPath = folderFile + "/" + newFileName;
			File _cardFirst = new File(cardFirstPath);
			if (!_cardFirst.exists()) {
				_cardFirst.createNewFile();
			}
			FileUtils.copyFile(cardFirst, _cardFirst);
			fileMap.put("cardFirst", diskPath + _subFilePath + "/" + newFileName);
		}
		if (cardTwo != null && cardTwo.exists()) {
			String newFileName = randomFileName(cardTwoFileName);
			String cardTwoPath = folderFile + "/" + newFileName;
			File _cardTwo = new File(cardTwoPath);
			if (!_cardTwo.exists()) {
				_cardTwo.createNewFile();
			}
			FileUtils.copyFile(cardTwo, _cardTwo);
			fileMap.put("cardTwo", diskPath + _subFilePath + "/" + newFileName);
		}
		return fileMap;
	}

	private String randomFileName(String fileName) {
		// messageCode
		String sub = "";
		if (fileName.contains(".")) {
			sub = fileName.substring(fileName.lastIndexOf("."), fileName.length());
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssms");
		String randName = sdf.format(new Date()) + randomString();
		if (sub != null && !"".equals(sub)) {
			randName += sub;
		}
		return randName;
	}

	/**
	 * 发送手机验证码
	 * 
	 * @throws Exception
	 * @throws SQLException
	 */
	public void sendPhoneCode() throws SQLException, Exception {
		String phone = this.getRequest().getParameter("phone");
		this.getResponse().setContentType("text/html;charset=UTF-8");
		PrintWriter writer = this.getResponse().getWriter();
		TLeaderExample tle = new TLeaderExample();
		tle.createCriteria().andPhoneEqualTo(phone);
		List list = tleadermanager.selectByExample(tle);
		if(null != list && list.size()>0){  //判断领秀手机号码是否存在
			writer.write("-1"); //手机号码已经绑定
		}else{
			String messageCode = randomString();
			boolean flag = sendMessage(phone, messageCode);
			if (flag) {
				this.getSession().setAttribute("apply_health_code_" + phone, messageCode);
				System.out.println("健康领袖手机验证码:\t" + messageCode);
				writer.write("1");
			} else {
				writer.write("0");
			}
		}
		this.getResponse().getWriter().flush();
		this.getResponse().getWriter().close();
	}

	/**
	 * 健康领袖公用发短信(仅限于健康领袖)
	 * 
	 * @param phone
	 * @param messageCode
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	private boolean sendMessage(String phone, String messageCode) throws SQLException, Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("mobiles", phone);
		// /1、342323。这是您的手机验证码，5分钟内有效。健康领秀，成就健康巨人。
		map.put("smsContent", messageCode + "。这是您的手机验证码，5分钟内有效。健康领秀，成就健康巨人。");
		ClientSubmit.buildRequestBySMS(map, tsysparametermanager.getKeys("sms"));

		return true;
	}

	/**
	 * 验证验证码
	 */
	public void verifyPhoneCode() {
		ResultData resultData = new ResultData();

		String phone = this.getRequest().getParameter("phone");// 手机号
		String verifyCode = this.getRequest().getParameter("verifyCode");// 验证码

		Pattern p = Pattern.compile("^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$");
		Matcher m = p.matcher(phone);
		if (phone == null || "".equals(phone) || !m.matches()) {
			resultData.setMessage("请输入有效的11位手机号");
			resultData.setStatus(0);
			this.writeObjectToResponse(resultData, ContentType.application_json);
			return;
		}
		if (verifyCode == null || "".equals(verifyCode)) {
			resultData.setMessage("请输入手机验证码");
			resultData.setStatus(0);
			this.writeObjectToResponse(resultData, ContentType.application_json);
			return;
		}
		String code = (String) this.getSession().getAttribute("apply_health_code_" + phone);
		if (code != null && code.equals(verifyCode)) {// 验证是否一致;
			resultData.setMessage("一致");
			resultData.setStatus(1);
		} else {
			resultData.setMessage("验证码不正确");
			resultData.setStatus(0);
		}
		this.writeObjectToResponse(resultData, ContentType.application_json);
	}

	public String randomString() {
		int i = (int) (Math.random() * 1000000 + 100000);
		String messageCode = String.valueOf(i);
		if (messageCode.length() == 7) {
			messageCode = messageCode.substring(0, 6);
		}
		return messageCode;
	}

	/**
	 * 个人中心点击健康领袖(审核通过跳转领袖中心,未申请跳转申请页面,未审核跳转等待审核页面)
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String healthLeader() throws SQLException {
		TMember tMember = (TMember) this.getSession().getAttribute("member");
		if (tMember == null) {
			// FIXME WWF跳转登录页面
			return ERROR;
		}
		TLeaderExample tLeaderExample = new TLeaderExample();
		tLeaderExample.createCriteria().andMemberIdEqualTo(tMember.getId());
		List<TLeader> list = tleadermanager.selectByExample(tLeaderExample);
		if (list == null || list.size() <= 0) {// 跳转申请页
			return "apply_health_leader";
		} else {
			TLeader tLeader = list.get(0);
			this.getRequest().setAttribute("tLeader", tLeader);
//			if (tLeader.getAuditType() != null && tLeader.getAuditType() == 1) {// 存在,审核通过,领袖中心
//				return "health_leader";
//			} else {// 审核等待页面
//				return "wait_health_leader";
//			}
			return "leader";
		}
	}

	/**
	 * 生成健康领袖二维码
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	public void createAllQRImage_hiddenAction() throws SQLException, IOException {
		TLeaderExample tLeaderExample = new TLeaderExample();
		tLeaderExample.createCriteria().andIdEqualTo(91L);
		List<TLeader> list = tleadermanager.selectByExample(tLeaderExample);
		for (TLeader tLeader : list) {
			String code = "";
			if (tLeader.getCode() == null) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssms");
				code = sdf.format(new Date()) + randomString();
				tLeader.setCode(code);
			} else {
				code = tLeader.getCode();
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssms");
			String fileName = sdf.format(new Date()) + randomString();

			File qrCodeDir = new File(this.getRequest().getSession().getServletContext().getRealPath("/")
					+ qrCodeDiskPath);
			File qrCodeFile = new File(this.getRequest().getSession().getServletContext().getRealPath("/")
					+ qrCodeDiskPath + fileName + ".jpg");
			if (!qrCodeDir.exists()) {
				qrCodeDir.mkdirs();
			}
			if (!qrCodeFile.exists()) {
				qrCodeFile.createNewFile();
			}
			FileOutputStream fileOutputStream = new FileOutputStream(qrCodeFile);
			String contentString = sharedLeaderUrl + "?code=" + code + "&hurl=" + leaderUrl;
			try {
				URL url = new URL(qrLogoPath);
				URLConnection uc = url.openConnection();
				uc.getInputStream();
				QRCodeZXingUtil.encoderQRCoder_logoUrl(contentString, fileOutputStream, qrLogoPath);
			} catch (IOException e) {
				log.error("生成健康领袖logo二维码不存在,配置链接为:[" + qrLogoPath + "]");
				QRCodeUtil.encoderQRCoder(contentString, fileOutputStream, 10);
			}
			tLeader.setDimensionalCodeUrl(qrCodeDiskPath + fileName + ".jpg");
			fileOutputStream.flush();
			fileOutputStream.close();
			System.out.println(tLeader.getRealName() + "的code为【" + code + "】\t\t二维码路径:"
					+ (qrCodeDiskPath + fileName + ".jpg"));
			tleadermanager.updateByPrimaryKeySelective(tLeader);
		}
	}

	/**
	 * 生成所有的健康领袖二维码
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	public void createAllQRImage_hiddenAction_all() throws SQLException, IOException {
		List<TLeader> list = tleadermanager.selectByExample(null);
		for (TLeader tLeader : list) {
			String code = "";
			if (tLeader.getCode() == null) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssms");
				code = sdf.format(new Date()) + randomString();
				tLeader.setCode(code);
			} else {
				code = tLeader.getCode();
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssms");
			String fileName = sdf.format(new Date()) + randomString();

			File qrCodeDir = new File(this.getRequest().getSession().getServletContext().getRealPath("/")
					+ qrCodeDiskPath);
			File qrCodeFile = new File(this.getRequest().getSession().getServletContext().getRealPath("/")
					+ qrCodeDiskPath + fileName + ".jpg");
			if (!qrCodeDir.exists()) {
				qrCodeDir.mkdirs();
			}
			if (!qrCodeFile.exists()) {
				qrCodeFile.createNewFile();
			}
			FileOutputStream fileOutputStream = new FileOutputStream(qrCodeFile);
			String contentString = sharedLeaderUrl + "?code=" + code + "&hurl=" + leaderUrl;
			try {
				URL url = new URL(qrLogoPath);
				URLConnection uc = url.openConnection();
				uc.getInputStream();
				QRCodeZXingUtil.encoderQRCoder_logoUrl(contentString, fileOutputStream, qrLogoPath);
			} catch (IOException e) {
				log.error("生成健康领袖logo二维码不存在,配置链接为:[" + qrLogoPath + "]");
				QRCodeUtil.encoderQRCoder(contentString, fileOutputStream, 10);
			}
			tLeader.setDimensionalCodeUrl(qrCodeDiskPath + fileName + ".jpg");
			fileOutputStream.flush();
			fileOutputStream.close();
			System.out.println(tLeader.getRealName() + "的code为【" + code + "】\t\t二维码路径:"
					+ (qrCodeDiskPath + fileName + ".jpg"));
			tleadermanager.updateByPrimaryKeySelective(tLeader);
		}
	}

	/**
	 * 第二张二维码(单个)
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	public void createSecoundQRCode() throws SQLException, IOException {
		TLeaderExample tLeaderExample = new TLeaderExample();
		tLeaderExample.createCriteria().andIdEqualTo(91L);
		List<TLeader> list = tleadermanager.selectByExample(tLeaderExample);
		for (TLeader tLeader : list) {
			if (tLeader.getCode() != null && !"".equals(tLeader.getCode())) {
				// savePath存海报的路径下
				File _savePath = new File(savePath);
				File secoundQRFile = new File(this.getRequest().getSession().getServletContext().getRealPath("/")
						+ savePath + tLeader.getId() + "_" + tLeader.getCode() + ".jpg");
				if (!_savePath.exists()) {
					_savePath.mkdirs();
				}
				if (!secoundQRFile.exists()) {
					secoundQRFile.createNewFile();
				}
				FileOutputStream fileOutputStream = new FileOutputStream(secoundQRFile);
				String content = "http://m.111yao.com/leader/leader!shareLeader.action?code=" + tLeader.getCode()
						+ "&hurl=" + java.net.URLEncoder.encode("/", "utf-8");
				try {
					URL url = new URL(qrLogoPath);
					URLConnection uc = url.openConnection();
					uc.getInputStream();
					QRCodeZXingUtil.encoderQRCoder_logoUrl(content, fileOutputStream, qrLogoPath);
				} catch (IOException e) {
					log.error("生成健康领袖logo二维码不存在,配置链接为:[" + qrLogoPath + "]");
					QRCodeUtil.encoderQRCoder(content, fileOutputStream, 10);
				}
				fileOutputStream.flush();
				fileOutputStream.close();
			}
		}
		this.writeObjectToResponse("生成成功", ContentType.text_html);
	}

	/**
	 * 第二张二维码(所有)
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	public void createSecoundQRCode_all() throws SQLException, IOException {
		// TLeaderExample tLeaderExample = new TLeaderExample();
		// tLeaderExample.createCriteria().andIdEqualTo(91L);
		List<TLeader> list = tleadermanager.selectByExample(null);
		for (TLeader tLeader : list) {
			if (tLeader.getCode() != null && !"".equals(tLeader.getCode())) {
				// savePath存海报的路径下
				File _savePath = new File(savePath);
				File secoundQRFile = new File(this.getRequest().getSession().getServletContext().getRealPath("/")
						+ savePath + tLeader.getId() + "_" + tLeader.getCode() + ".jpg");
				if (!_savePath.exists()) {
					_savePath.mkdirs();
				}
				if (!secoundQRFile.exists()) {
					secoundQRFile.createNewFile();
				}
				FileOutputStream fileOutputStream = new FileOutputStream(secoundQRFile);
				String content = "http://m.111yao.com/leader/leader!shareLeader.action?code=" + tLeader.getCode()
						+ "&hurl=" + java.net.URLEncoder.encode("/", "utf-8");
				try {
					URL url = new URL(qrLogoPath);
					URLConnection uc = url.openConnection();
					uc.getInputStream();
					QRCodeZXingUtil.encoderQRCoder_logoUrl(content, fileOutputStream, qrLogoPath);
				} catch (IOException e) {
					log.error("生成健康领袖logo二维码不存在,配置链接为:[" + qrLogoPath + "]");
					QRCodeUtil.encoderQRCoder(content, fileOutputStream, 10);
				}
				fileOutputStream.flush();
				fileOutputStream.close();
			}
		}
	}

	/**
	 * 海报图片生成
	 * 
	 * @throws SQLException
	 */
	public void createHaibaoHiddenURL() throws SQLException {
		TLeaderExample tLeaderExample = new TLeaderExample();
		tLeaderExample.createCriteria().andIdEqualTo(91L);
		List<TLeader> list = tleadermanager.selectByExample(tLeaderExample);
		File qrCodeDir = new File(this.getRequest().getSession().getServletContext().getRealPath("/") + qrCodeDiskPath);
		if (!qrCodeDir.exists()) {
			qrCodeDir.mkdirs();
		}
		for (TLeader tLeader : list) {
			if (tLeader != null && tLeader.getCode() != null && tLeader.getMemberId() != null) {
				String haibaoName = tLeader.getCode() + "_" + tLeader.getId();
				TMember tMember = tmembermanager.selectByPrimaryKey(tLeader.getMemberId());
				if (tMember != null) {
					// File _saveFile = new
					// File(this.getRequest().getSession().getServletContext().getRealPath("/")
					// + savePath + haibaoName + ".jpg");
					createPosterImgHttpQR(haibaoName, tMember, uiHttp + tLeader.getDimensionalCodeUrl());
					System.out.println("【" + tMember.getUserName() + "】生成海报成功，名称" + haibaoName);
				}
			}
		}
		this.writeObjectToResponse("海报生成成功", ContentType.text_html);
	}

	/**
	 * 海报图片生成(所有)
	 * 
	 * @throws SQLException
	 */
	public void createHaibaoHiddenURL_all() throws SQLException {
		List<TLeader> list = tleadermanager.selectByExample(null);
		File qrCodeDir = new File(this.getRequest().getSession().getServletContext().getRealPath("/") + qrCodeDiskPath);
		if (!qrCodeDir.exists()) {
			qrCodeDir.mkdirs();
		}
		for (TLeader tLeader : list) {
			if (tLeader != null && tLeader.getCode() != null && tLeader.getMemberId() != null) {
				String haibaoName = tLeader.getCode() + "_" + tLeader.getId();
				TMember tMember = tmembermanager.selectByPrimaryKey(tLeader.getMemberId());
				if (tMember != null) {
					// File _saveFile = new
					// File(this.getRequest().getSession().getServletContext().getRealPath("/")
					// + savePath + haibaoName + ".jpg");
					createPosterImgHttpQR(haibaoName, tMember, uiHttp + tLeader.getDimensionalCodeUrl());
					System.out.println("【" + tMember.getUserName() + "】生成海报成功，名称" + haibaoName);
				}
			}
		}
		this.writeObjectToResponse("海报生成成功", ContentType.text_html);
	}

	/**
	 * 健康领袖首页的二维码(新的二维码)
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	public void createNewLeaderQR() throws SQLException, IOException {
		TLeaderExample tLeaderExample = new TLeaderExample();
		tLeaderExample.createCriteria().andIdEqualTo(91L);
		List<TLeader> list = tleadermanager.selectByExample(tLeaderExample);
		File _file = new File(this.getRequest().getSession().getServletContext().getRealPath("/") + codeQR);// www/static/
		if (!_file.exists()) {
			_file.mkdirs();
		}
		for (TLeader tLeader : list) {
			File codeQRFile = new File(this.getRequest().getSession().getServletContext().getRealPath("/") + codeQR
					+ "/" + tLeader.getCode() + ".jpg");
			FileOutputStream fileOutputStream = new FileOutputStream(codeQRFile);
			System.out.println("最新二维码路径:\t\t" + codeQRFile.getAbsolutePath());
			String content = goHaibaoUrl + "?code=" + tLeader.getCode() + "&id=" + tLeader.getId();
			try {
				URL url = new URL(qrLogoPath);
				URLConnection uc = url.openConnection();
				uc.getInputStream();
				QRCodeZXingUtil.encoderQRCoder_logoUrl(content, fileOutputStream, qrLogoPath);
			} catch (IOException e) {
				QRCodeUtil.encoderQRCoder(content, fileOutputStream, 10);
			}
			fileOutputStream.flush();
			fileOutputStream.close();
		}
	}

	/**
	 * 健康领袖首页的二维码(新的二维码)所有
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	public void createNewLeaderQR_all() throws SQLException, IOException {
		List<TLeader> list = tleadermanager.selectByExample(null);
		File _file = new File(this.getRequest().getSession().getServletContext().getRealPath("/") + codeQR);// www/static/
		if (!_file.exists()) {
			_file.mkdirs();
		}
		for (TLeader tLeader : list) {
			File codeQRFile = new File(this.getRequest().getSession().getServletContext().getRealPath("/") + codeQR
					+ "/" + tLeader.getCode() + ".jpg");
			FileOutputStream fileOutputStream = new FileOutputStream(codeQRFile);
			System.out.println("最新二维码路径:\t\t" + codeQRFile.getAbsolutePath());
			String content = goHaibaoUrl + "?code=" + tLeader.getCode() + "&id=" + tLeader.getId();
			try {
				URL url = new URL(qrLogoPath);
				URLConnection uc = url.openConnection();
				uc.getInputStream();
				QRCodeZXingUtil.encoderQRCoder_logoUrl(content, fileOutputStream, qrLogoPath);
			} catch (IOException e) {
				QRCodeUtil.encoderQRCoder(content, fileOutputStream, 10);
			}
			fileOutputStream.flush();
			fileOutputStream.close();
		}
	}

	/**
	 * http的二维码的海报
	 */
	public void createPosterImgHttpQR(String backImgName, TMember tMember, String httpQRCode) {

		String fontName = "宋体";
		int fontStyle = 10;
		int color = 0;
		int fontSize = 36;
		int x = 190;
		int y = 370;
		URL url = null;
		URLConnection connection = null;
		try {
			url = new URL(defaultBackground);
			connection = url.openConnection();
			connection.setDoOutput(true);
			BufferedImage image = ImageIO.read(connection.getInputStream());
			File _savePath = new File(this.getRequest().getSession().getServletContext().getRealPath("/") + savePath);
			File _saveFile = new File(this.getRequest().getSession().getServletContext().getRealPath("/") + savePath
					+ backImgName + ".jpg");
			if (!_savePath.exists()) {
				_savePath.mkdirs();
			}
			if (!_saveFile.exists()) {
				_saveFile.createNewFile();
			}
			FileOutputStream fout = new FileOutputStream(this.getRequest().getSession().getServletContext()
					.getRealPath("/")
					+ savePath + backImgName + ".jpg");
			ImageIO.write(image, "jpg", fout);
			fout.flush();
			fout.close();
		} catch (MalformedURLException e) {// http背景图片不存在
			log.error("海报背景图片不存在");
			e.printStackTrace();
		} catch (IOException e) {// http背景图片不存在
			log.error("海报背景图片不存在");
			e.printStackTrace();
		}
		String _backImgName = this.getRequest().getSession().getServletContext().getRealPath("/") + savePath
				+ backImgName + ".jpg";
		String httpHeadFile = "";
		if (tMember.getHeadPortrait() != null && !"".equals(tMember.getHeadPortrait())) {
			String getHeadPortrait = tMember.getHeadPortrait();
			if (getHeadPortrait.startsWith("http://")) {
				httpHeadFile = tMember.getHeadPortrait();// 头像
			} else {
				httpHeadFile = uiHttp + tMember.getHeadPortrait();// 头像
			}
			try {
				url = new URL(httpHeadFile);
				connection = url.openConnection();
				connection.setDoOutput(true);
				ImageIO.read(connection.getInputStream());
			} catch (MalformedURLException e) {
				e.printStackTrace();
				httpHeadFile = defaultHead;
			} catch (IOException e) {
				e.printStackTrace();
				httpHeadFile = defaultHead;
			}
		} else {
			try {
				url = new URL(defaultHead);
				connection = url.openConnection();
				connection.setDoOutput(true);
				ImageIO.read(connection.getInputStream());
				httpHeadFile = defaultHead;
			} catch (MalformedURLException e) {
				e.printStackTrace();
				httpHeadFile = null;
			} catch (IOException e) {
				e.printStackTrace();
				httpHeadFile = null;
			}
		}

		try {
			url = new URL(httpQRCode);
			connection = url.openConnection();
			connection.setDoOutput(true);
			ImageIO.read(connection.getInputStream());
		} catch (MalformedURLException e) {
			e.printStackTrace();
			log.error(tMember.getUserName() + "\t二维码有误");
			httpQRCode = null;
		} catch (IOException e) {
			e.printStackTrace();
			log.error(tMember.getUserName() + "\t二维码有误");
			httpQRCode = null;
		}

		System.out.println("----------------------------------------------------------");
		System.out.println("背景图片:【" + _backImgName + "】");
		System.out.println("头像图片:【" + httpHeadFile + "】");
		System.out.println("二维码图片:【" + httpQRCode + "】");
		String nickName = tMember.getNickName() == null ? tMember.getUserName() : tMember.getNickName();
		SharePoster.pressTextAndImgHttpQR(httpHeadFile, httpQRCode, nickName, _backImgName, fontName, fontStyle, color,
				fontSize, x, y);

	}

	@Override
	public Object getModel() {
		return null;
	}

	@Override
	public void setModel(Object o) {
	}

	public TLeaderManager getTleadermanager() {
		return tleadermanager;
	}

	public void setTleadermanager(TLeaderManager tleadermanager) {
		this.tleadermanager = tleadermanager;
	}

	public CLocationManager getClocationmanager() {
		return clocationmanager;
	}

	public void setClocationmanager(CLocationManager clocationmanager) {
		this.clocationmanager = clocationmanager;
	}

	class ResultData {
		private int status;
		private String message;

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {

		// FileOutputStream fileOutputStream = new
		// FileOutputStream("e:\\temp\\a.jpg");
		// QRCodeUtil.encoderQRCoder("http://www.baidu.com", fileOutputStream,
		// 20);

		// try {
		// URL url = new URL("http://new.111yao.com/web/img/01.jpg");
		// URLConnection uc = url.openConnection();
		// InputStream in = uc.getInputStream();
		// } catch (IOException e) {
		// System.out.println("没有");
		// }
		// FileOutputStream fileOutputStream = new
		// FileOutputStream("E:\\temp\\qrImage.jpg");
		//
		// boolean ret = QRCodeZXingUtil.encoderQRCoder_logoUrl(
		// "http://www.new111yao.com/leader/leader\\!shareLeader.action" +
		// "?code=12&hurl=" + "12",
		// fileOutputStream, "http://www.111.com/static/image/qr_logo.jpg");
		//
		// System.out.println(ret);
		// for (int j = 0; j < 1000; j++) {
		//
		// int i = (int) (Math.random() * 1000000 + 100000);
		// String messageCode = String.valueOf(i);
		// System.out.println(messageCode + "\t||" + Math.random());
		// }
		// String ii = "adfasdfasdf.asdfasdflasdf.png";
		// System.out.println(ii.substring(ii.lastIndexOf("."), ii.length()));

	}

	public File getHeadImage() {
		return headImage;
	}

	public void setHeadImage(File headImage) {
		this.headImage = headImage;
	}

	public File getLeaderImage1() {
		return leaderImage1;
	}

	public void setLeaderImage1(File leaderImage1) {
		this.leaderImage1 = leaderImage1;
	}

	public File getLeaderImage2() {
		return leaderImage2;
	}

	public void setLeaderImage2(File leaderImage2) {
		this.leaderImage2 = leaderImage2;
	}

	public File getLeaderImage3() {
		return leaderImage3;
	}

	public void setLeaderImage3(File leaderImage3) {
		this.leaderImage3 = leaderImage3;
	}

	public File getLeaderImage4() {
		return leaderImage4;
	}

	public void setLeaderImage4(File leaderImage4) {
		this.leaderImage4 = leaderImage4;
	}

	public File getLeaderImage5() {
		return leaderImage5;
	}

	public void setLeaderImage5(File leaderImage5) {
		this.leaderImage5 = leaderImage5;
	}

	public File getCardFirst() {
		return cardFirst;
	}

	public void setCardFirst(File cardFirst) {
		this.cardFirst = cardFirst;
	}

	public File getCardTwo() {
		return cardTwo;
	}

	public void setCardTwo(File cardTwo) {
		this.cardTwo = cardTwo;
	}

	public String getHeadImageFileName() {
		return headImageFileName;
	}

	public void setHeadImageFileName(String headImageFileName) {
		this.headImageFileName = headImageFileName;
	}

	public String getLeaderImage1FileName() {
		return leaderImage1FileName;
	}

	public void setLeaderImage1FileName(String leaderImage1FileName) {
		this.leaderImage1FileName = leaderImage1FileName;
	}

	public String getLeaderImage2FileName() {
		return leaderImage2FileName;
	}

	public void setLeaderImage2FileName(String leaderImage2FileName) {
		this.leaderImage2FileName = leaderImage2FileName;
	}

	public String getLeaderImage3FileName() {
		return leaderImage3FileName;
	}

	public void setLeaderImage3FileName(String leaderImage3FileName) {
		this.leaderImage3FileName = leaderImage3FileName;
	}

	public String getLeaderImage4FileName() {
		return leaderImage4FileName;
	}

	public void setLeaderImage4FileName(String leaderImage4FileName) {
		this.leaderImage4FileName = leaderImage4FileName;
	}

	public String getLeaderImage5FileName() {
		return leaderImage5FileName;
	}

	public void setLeaderImage5FileName(String leaderImage5FileName) {
		this.leaderImage5FileName = leaderImage5FileName;
	}

	public String getCardFirstFileName() {
		return cardFirstFileName;
	}

	public void setCardFirstFileName(String cardFirstFileName) {
		this.cardFirstFileName = cardFirstFileName;
	}

	public String getCardTwoFileName() {
		return cardTwoFileName;
	}

	public void setCardTwoFileName(String cardTwoFileName) {
		this.cardTwoFileName = cardTwoFileName;
	}

	public TLeaderImageManager getTleaderimagemanager() {
		return tleaderimagemanager;
	}

	public void setTleaderimagemanager(TLeaderImageManager tleaderimagemanager) {
		this.tleaderimagemanager = tleaderimagemanager;
	}

	public TMemberManager getTmembermanager() {
		return tmembermanager;
	}

	public void setTmembermanager(TMemberManager tmembermanager) {
		this.tmembermanager = tmembermanager;
	}

}
