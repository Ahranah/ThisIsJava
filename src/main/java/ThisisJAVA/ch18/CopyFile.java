package ThisisJAVA.ch18;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CopyFile {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            // 원본 파일 경로 입력
            System.out.print("원본 파일 경로: ");
            String originalPath = br.readLine();

            // 복사할 파일 경로 입력
            System.out.print("복사 파일 경로: ");
            String targetPath = br.readLine();

            File originalFile = new File(originalPath);
            File targetFile = new File(targetPath);

            // 1. 원본 파일이 존재하지 않으면 에러 출력
            if (!originalFile.exists()) {
                System.out.println("원본 파일이 존재하지 않습니다.");
                return;
            }

            // 2. 복사할 경로에 디렉토리가 없으면 생성
            if (!targetFile.getParentFile().exists()) {
                targetFile.getParentFile().mkdirs();
            }

            // 3. 복사 진행
            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(originalFile));
                 BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetFile))) {

                byte[] buffer = new byte[1024]; // 1KB 버퍼
                int bytesRead;

                while ((bytesRead = bis.read(buffer)) != -1) {
                    bos.write(buffer, 0, bytesRead);
                }
            }

            // 4. 복사 완료 메시지
            System.out.println("복사가 성공되었습니다.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
