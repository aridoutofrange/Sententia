package com.ramadhira.Sententia;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Model {
   private final String db = "jdbc:mysql://localhost/runkad";
   private final String dbUser = "sware";
   private final String dbPassword = "sware";
   private Connection conn = null;
   public String tableName;

   public Model(){
      try{
         conn = DriverManager.getConnection(db, dbUser, dbPassword);
      }catch(Exception err){
         System.out.println(err);
      }
   }
   private String getName(){
      try{
         Class<?> o = this.getClass();
         Field n = o.getDeclaredField("tableName");
         n.setAccessible(true);
         String v = (String) n.get(this);
         return v;
      }catch(Exception e){
         System.out.println(e);
         return "fail";
      }
   }
   public ResultSet search(String clauses) throws Exception {
      Statement stmt = conn.createStatement();
      if(clauses.length() > 0) clauses = " where " + clauses;
      String query = "SELECT * FROM " + getName() + clauses;
      return stmt.executeQuery(query);
   }
   public ResultSet query(String query) throws Exception {
      Statement stmt = conn.createStatement();
      return stmt.executeQuery(query);
   }

   public int create(String data) throws Exception {
      Statement stmt = conn.createStatement();
      String query = "INSERT INTO "+ getName()+ " VALUES " + data;
      return stmt.executeUpdate(query);
   }

   public int write(String data,String clauses) throws Exception {
      Statement stmt = conn.createStatement();
      if(clauses.length() > 0) clauses = " where " + clauses;
      String query = "UPDATE "+ getName()+ " SET " + data + " " + clauses;
      return stmt.executeUpdate(query);
   }

   public int unlink(String clauses) throws Exception {
      Statement stmt = conn.createStatement();
      if(clauses.length() > 0) clauses = " where " + clauses;
      return stmt.executeUpdate("DELETE FROM "+ getName()+ " " + clauses);
   }

}
