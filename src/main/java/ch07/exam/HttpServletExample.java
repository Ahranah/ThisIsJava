package ch07.exam;

import java.io.FileInputStream;

public class HttpServletExample {
    public static void main(String[] args) {
        LoginServlet loginServlet = new LoginServlet();
        loginServlet.service();

        FileDownloadServlet fileDownloadServlet = new FileDownloadServlet();
        fileDownloadServlet.service();

        // parameter polymorphism
        method(new LoginServlet());
        method(new FileDownloadServlet());
    }

    // 자동타입변환(자식이 부모로 변환)
    public static void method(HttpServlet servlet) {
        // 재정의된 메소드 호출
        servlet.service();
    }
}
