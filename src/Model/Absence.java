/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Controller.ConnectionDatabase;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Absence {
    
    private ConnectionDatabase con;
    private Statement st;
    private String query;
    private ResultSet res;
    private int id;
    private String nip;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }
    
    public void Save(String nip, String nama, Date tanggal, String masuk, String pulang, String ket) {
        con = new ConnectionDatabase();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_absensi(nip, nama, tanggal, masuk, pulang, ket)values('" + nip + "','" + nama + "', '"+tanggal+"', '"+masuk+"', '"+pulang+"', '"+ket+"')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
        } catch (SQLException e) {
        }
    }
    
    public void Update(int Id, String ket) {
        con = new ConnectionDatabase();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_absensi set ket='" + ket + "'where Id = '" + Id + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Update");
        } catch (SQLException e) {

        }
    }
    
    public void Delete(int id) {
        con = new ConnectionDatabase();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "delete from tb_absensi where Id = '" + id + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");
        } catch (SQLException e) {

        }
    }

    public String[][] ShowData() {

        res = null;
        String[][] data = null;
        con = new ConnectionDatabase();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(Id) AS Jumlah FROM tb_absensi";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_absensi";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][7];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("Id");
                data[r][1] = res.getString("nip");
                data[r][2] = res.getString("nama");
                data[r][3] = res.getString("tanggal");
                data[r][4] = res.getString("masuk");
                data[r][5] = res.getString("pulang");
                data[r][6] = res.getString("ket");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][7];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 7; c++) {
                    data[r][c] = tmpArray[r][c];
                }
            }
            st.close();
            con.conn.close();
        } catch (SQLException e) {
            System.err.println("SQLException : " + e.getMessage());
        }
        return data;
    }

    public String[][] SearchData(String search) {

        res = null;
        String[][] data = null;
        con = new ConnectionDatabase();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(nip) AS Jumlah FROM tb_pegawai";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_absensi where nip like '%"+ search +"%' or nama like '%"+ search +"%' or tanggal like '%"+search+"%'";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][6];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("nip");
                data[r][1] = res.getString("nama");
                data[r][2] = res.getString("tanggal");
                data[r][3] = res.getString("masuk");
                data[r][4] = res.getString("pulang");
                data[r][5] = res.getString("ket");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][6];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 6; c++) {
                    data[r][c] = tmpArray[r][c];
                }
            }
            st.close();
            con.conn.close();
        } catch (SQLException e) {
            System.err.println("SQLException : " + e.getMessage());
        }
        return data;
    }
}
