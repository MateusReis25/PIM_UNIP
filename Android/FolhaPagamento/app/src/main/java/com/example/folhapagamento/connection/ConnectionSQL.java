package com.example.folhapagamento.connection;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQL {
    public static Connection connectionClass() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        String ip="", port="", db="", username="", password="";

        StrictMode.ThreadPolicy a = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(a);

        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        String connectURL = "jdbc:jtds:sqlserver://" + ip + ":" + port + ";databasename=" + db + ";user=" + username + ";password=" + password + ";";
        connection = DriverManager.getConnection(connectURL);

        return connection;
    }
}
