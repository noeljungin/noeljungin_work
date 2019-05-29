package part4_132;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FilesCopys {
	
	public static void copyUsingFiles(File source, File target) {
		try {
			Files.copy(source.toPath(), target.toPath());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		File ff = new File("upload");
		File[] ffs = ff.listFiles();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat fds = new SimpleDateFormat("yyyyMMdd");
		
		for (File fff: ffs) {
			String absfile = fff.getAbsolutePath();
			
			if (fff.isFile()) {
				String f = (absfile).substring(absfile.lastIndexOf("\\")+1);
				String fre = "";
				if (f.indexOf('.') >= 0) {
					fre = f.substring(0, f.indexOf('.'));
				}
				Date longDay = new Date(Long.parseLong(fre));
				String fname = sdf.format(longDay);
				String newFname = fds.format(longDay);
				System.out.println(fname + "\t\t" + newFname);
				
				File newFile = new File("upload\\" + newFname);
				File toFile = new File("upload\\" + newFname + "\\" + f);
				
				if (!newFile.exists()) {
					boolean iss = newFile.mkdirs();
					if (iss) {
						copyUsingFiles(fff, toFile);
					}
				} else {
					copyUsingFiles(fff, toFile);
				}
			}
		}
	}
}
