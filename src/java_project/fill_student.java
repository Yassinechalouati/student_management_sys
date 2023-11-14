/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_project;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class fill_student {
    String email;
    String pass;
    public fill_student(String email, String pass)
    {
        this.email=email;
        this.pass=pass;
    }
    public void aff ()
    {
        System.out.println(email+pass);
    }
    public void setLabel(Etudiant etudiant)
    {
        Connection con = Java_project.Dbconnection();
        try{
        PreparedStatement ps = con.prepareStatement("select nom , prenom , id_etudiant ,filiere from etudiant e , classe c \n" +"where e.id_classe = c.id_classe and e.login =?");
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String prenom = rs.getString ("prenom");
        String nom = rs.getString ("nom");
        String id = rs.getString("id_etudiant");
        String filiere = rs.getString("filiere");
        etudiant.id_etudiant.setText(id);
        etudiant.prenom.setText(prenom);
        etudiant.nom.setText(nom);
        etudiant.filiere.setText(filiere);
        PreparedStatement p = con.prepareStatement("select e1.nom , e1.prenom ,libelle,numseance,date from absence a,enseignant e1,etudiant e2,matiere m where e2.id_etudiant = ? and a.id_enseignant=e1.id_enseignant and a.id_mat=m.id_mat and a.id_etudiant = e2.id_etudiant");
        p.setString(1, id);
        ResultSet r = p.executeQuery();
        DefaultTableModel model = (DefaultTableModel)etudiant.jTable1.getModel();
        Object[] Row;
        while (r.next())
        {
            Row=new Object[4];
            Row[2] = r.getString("nom")+" "+r.getString("prenom");
            Row[3] = r.getString("libelle");
            Row[0] = r.getInt("numseance");
            Row[1] = r.getString("date");
            model.addRow(Row);
        }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            
        }
        finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(fill_student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
