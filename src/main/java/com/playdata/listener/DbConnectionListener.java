package com.playdata.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class DbConnectionListener implements ServletContextListener {
    // web.xml에서 context-param 에서 지정한 값을 불러오기
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String dbUrl = sce.getServletContext().getInitParameter("DB_URL");
        String dbUser = sce.getServletContext().getInitParameter("DB_USER");
        String dbPassword = sce.getServletContext().getInitParameter("DB_PASSWORD");

        try {
            // 드라이버 로드
            Class.forName("org.mariadb.jdbc.Driver");

            // Connection 객체 생성(생성이 되었다면 DB와 연결이 된 것)
            Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

            // 생성된 Connection 객체를 ServletContext에 Attribute로 저장
            sce.getServletContext().setAttribute("conn", conn);
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // ServletContext가 종료(WAS:Tomcat 종료)될 때 Connection 객체를 close --> 메모리 누수 방지
        Connection conn = (Connection) sce.getServletContext().getAttribute("conn");
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
