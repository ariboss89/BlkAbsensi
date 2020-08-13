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
public class Pegawai {
    
    private ConnectionDatabase con;
    private Statement st;
    private String query;
    private ResultSet res;
    private String idbagian;

    public String getIdbagian() {
        return idbagian;
    }

    public void setIdbagian(String idbagian) {
        this.idbagian = idbagian;
    }
    
    public void Save(String nip, String nama, Date tanggal, String pekerjaan, String status, String agama, String idbagian, String jabatan, String alamat) {
        con = new ConnectionDatabase();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_pegawai(nip, nama, tanggal, pekerjaan, status, agama, idbagian, jabatan, alamat)values('" + nip + "','" + nama + "','" + tanggal + "','" + pekerjaan + "','" + status + "','" + agama + "','" + idbagian + "','" + jabatan + "', '"+alamat+"')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
        } catch (SQLException e) {
        }
    }
    
    public void Update(String nip, String nama, Date tanggal, String pekerjaan, String status, String agama, String idbagian, String jabatan, String alamat) {
        con = new ConnectionDatabase();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_pegawai set nama='" + nama + "', tanggal='" + tanggal + "', pekerjaan='" + pekerjaan + "', status='" + status + "', agama = '"+ agama +"', idbagian='" + idbagian + "', jabatan='" + jabatan + "', alamat='" + alamat + "' where nip = '" + nip + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Update");
        } catch (SQLException e) {

        }
    }
    
    public void Delete(String nip) {
        con = new ConnectionDatabase();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "delete from tb_pegawai where nip = '" + nip + "'";
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
            query = "SELECT COUNT(nip) AS Jumlah FROM tb_pegawai";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_pegawai";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][9];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("nip");
                data[r][1] = res.getString("nama");
                data[r][2] = res.getString("tanggal");
                data[r][3] = res.getString("pekerjaan");
                data[r][4] = res.getString("status");
                data[r][5] = res.getString("agama");
                data[r][6] = res.getString("idbagian");
                data[r][7] = res.getString("jabatan");
                data[r][8] = res.getString("alamat");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][9];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 9; c++) {
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
            query = "select *from tb_pegawai where nip like '%"+ search +"%' or nama like '%"+ search +"%'";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][9];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("nip");
                data[r][1] = res.getString("nama");
                data[r][2] = res.getString("tanggal");
                data[r][3] = res.getString("pekerjaan");
                data[r][4] = res.getString("status");
                data[r][5] = res.getString("agama");
                data[r][6] = res.getString("idbagian");
                data[r][7] = res.getString("jabatan");
                data[r][8] = res.getString("alamat");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][9];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 9; c++) {
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
