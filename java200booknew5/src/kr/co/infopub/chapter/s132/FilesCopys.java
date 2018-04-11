package kr.co.infopub.chapter.s132;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
public class FilesCopys {
 public static void copyUsingFiles(File source, File target) {
	try {
		Files.copy(source.toPath(), target.toPath());
	} catch (IOException e) {
		System.out.println(e);
	}
 }	
 public static void main(String[] args) {
	File ff=new File("upload");
	File[] ffs=ff.listFiles();
	// 2017-05-03 01:23
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");	
	SimpleDateFormat fds=new SimpleDateFormat("yyyyMMdd");  // 20170503
	for (File fff: ffs) {
		String absfile=fff.getAbsolutePath();
		if(fff.isFile()){
			// 파일이름 23424123123.txt
			String f=(absfile).substring(absfile.lastIndexOf("\\")+1);
			String fre="";
			if(f.indexOf('.')>=0){
				fre=f.substring(0,f.indexOf('.'));
			}
			Date longDay=new Date(Long.parseLong(fre)); //long-> Date
			String fname=sdf.format(longDay);           //Date -> String
			String newFname=fds.format(longDay);        // 23424123123
			System.out.println(fname+"\t\t"+newFname);  //Date -> String
			// 23424123123.txt -> 20170503/23424123123.txt
			File newFile=new File("upload\\"+newFname); //옮기려고 하는 디렉토리
			File toFile=new File("upload\\"+newFname+"\\"+f);//옮기려는 파일
			if(!newFile.exists()){  //디렉토리가 존재하지 않는가?
				boolean iss=newFile.mkdirs();   //존재하지 않으면 만들자
				if(iss){
					copyUsingFiles(fff, toFile);//파일 복사
				}
			}else{
				 copyUsingFiles(fff, toFile);//파일복사
			}
		}
	}
 }
}
