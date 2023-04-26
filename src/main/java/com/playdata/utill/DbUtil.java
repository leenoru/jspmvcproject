package com.playdata.utill;

import javax.servlet.ServletContext;
import java.sql.Connection;

public interface DbUtil {
    Connection getConnection(ServletContext servletContext);
}
