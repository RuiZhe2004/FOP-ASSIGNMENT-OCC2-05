/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week01;

/**
 *
 * @author szeyu
 */
public class MyProfile {
       
    public String name;
    private String matricID;
    public String email;
    public String address;
    
    public void PersonalInfo(String name, String matricID, String email, String address){
        this.name = name;
        this.matricID = matricID;
        this.email = email;
        this.address = address;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public String getMatricID(){
        return matricID;
    }
    public void setMatricID(String name){
        this.name = name;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String name){
        this.name = name;
    }
    
    public String getAddress(){
        return address;
    }
    public void setAddress(String name){
        this.name = name;
    }
    

    public static void main(String[] args){
        PersonalInfo person = new PersonalInfo("Sim", "23005023", "", "");
    }
}
