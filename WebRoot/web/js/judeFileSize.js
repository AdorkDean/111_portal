        var maxsize = 2*1024*1024;//2M  
        var errMsg = "上传的附件文件不能超过2M！！！";  
        var tipMsg = "您的浏览器暂不支持计算上传文件的大小，确保上传文件不要超过2M，建议使用IE、FireFox、Chrome浏览器。";  
        var  browserCfg = {};  
        var ua = window.navigator.userAgent;  
        if (ua.indexOf("MSIE")>=1){  
            browserCfg.ie = true;  
        }else if(ua.indexOf("Firefox")>=1){  
            browserCfg.firefox = true;  
        }else if(ua.indexOf("Chrome")>=1){  
            browserCfg.chrome = true;  
        }  
        function checkfile(){  
            try{  
                var obj_file = document.getElementById("fileId");  
                if(obj_file.value==""){  
                    alert("请先选择上传文件");  
                    return;  
                }  
                var filesize = 0;  
                if(browserCfg.firefox || browserCfg.chrome ){  
                    filesize = obj_file.files[0].size;  
                }else{  
                    var obj_img = document.getElementById('fileId');  
                     
                    alert(obj_img.size); 
                return;  
                }  
                if(filesize==-1){  
                    alert(tipMsg);  
                    return;  
                }else if(filesize>maxsize){  
                    alert(errMsg);  
                    return;  
                }else{  
                    alert("文件大小符合要求");  
                    return;  
                }  
            }catch(e){  
                alert(e);  
            }  
        }  
