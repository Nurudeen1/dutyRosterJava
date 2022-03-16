package com.dutyroster;
import com.dutyroster.models.Member;
import java.sql.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class DbConnection {

    public static Connection connect(){
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String path = "jdbc:sqlite:/Users/mohammedabdulai/Documents/Project/dutyRosterJava/app/src/main/resources/mem.db";
            conn = DriverManager.getConnection(path);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return conn;
    }

    private List<Member> members;

    public DbConnection(){
        members = new ArrayList<>();
    }
    public List<Member> getMembers() {
        return members;
    }

    public Member whoIsIncharge(){
       return members.get(DutyCalculator.calc(members.size()));
    }

    public void fetchAll(){
        String sql = "SELECT * FROM Members";
        try{
            Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet data = stmt.executeQuery(sql);
            while(data.next()){
                data.getInt("id");
                members.add(new Member(data.getString("name"),
                        data.getString("email"),data.getString("phone")));
            }
            data.close();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
