/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cdms_warehouse;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import sms.Global_V;

/**
 *
 * @author Azeem
 */
public class CDMS_Warehouse extends JPanel{
    JPanel workArea=new JPanel(); 
    public sms_component.Nav nav; 
    sms_library.C c=null; 
    CDMS_Warehouse(sms_library.C c){
        this.c=c; 
    int w=1400; 
    int h=3000; 
    /*
    try{
        w=Integer.parseInt(st.get("screenW").toString());
        h=Integer.parseInt(st.get("screenH").toString());
    }catch(Exception e){}*/
    this.setSize(w,h);
    this.setPreferredSize(new Dimension(w,h));
    this.setLayout(new BorderLayout());
    
    String[] buttonsText={"Index", "Stock","History","Xyz"}; 
    String[] buttonCMD={"index", "stock","history","xyz"}; 
    String[] moreButtonsText={"DashBoard"}; 
    String[] moreButtonCMD={"dashboard"}; 
    
    nav=new sms_component.Nav(" WAREHOUSE",buttonsText,buttonCMD,moreButtonsText,moreButtonCMD,cmd); 
   
    //workArea.setBorder(BorderFactory.createLineBorder(Color.red));
    this.add(nav,BorderLayout.WEST);
   // this.add(workArea,BorderLayout.CENTER); 
    workArea.setBackground(Color.white);
    JScrollPane jsp=new JScrollPane(workArea); 
    this.add(jsp,BorderLayout.CENTER); 
    workArea.setPreferredSize(new Dimension(1400,2000));
    //ActionMap am=jsp.getActionMap(); 
    //am.remove("scrollDown");
   // am.remove("scrollUp");
    
    jsp.getActionMap().put("unitScrollRight", new AbstractAction(){
    @Override
    public void actionPerformed(ActionEvent e) {
    }});
jsp.getActionMap().put("unitScrollDown", new AbstractAction(){
    @Override
    public void actionPerformed(ActionEvent e) {
    }});
    
    this.setPreferredSize(new Dimension(1000,3000));
    workArea.setLayout(new FlowLayout(FlowLayout.LEFT));
    this.add(jsp,BorderLayout.CENTER); 
     //showNewProductScreen();
     
    
    
    }
    
    
      sms_library.C cmd=new sms_library.C() {

        @Override
        public void cmd(Object o) {
            
        }

        @Override
        public void cmd(String string) {
            System.out.println("CMD = "+string);
         
            switch(string.toLowerCase()){
               // case "add_new"  :   showNewProductScreen();  break;  
              
                case "index": showIndexScreen(); break; 
                case "stock": showStockScreen(); break; 
                case "history": showHistoryScreen(); break; 
                    
                    
                case "dashboard":     c.cmd(sms_library.Departments.DASHBOARD); break; 
                default:JOptionPane.showMessageDialog(null, "This section is not approved yet. ","Notification",JOptionPane.INFORMATION_MESSAGE);break; 
            }  
            

           
            
            
            
        }

        @Override
        public void cmd(String string, Object o) {
            System.out.println("---------------"+string);
            switch(string){
                
                //case "Define New": showStudentAccount((int)o); break;     
                //case "Search ": showGroupAccount((int)o); break; 
                    
                    
                    
           //               case "edit":showEditForm((int)o); break;     
                
            
            }
        }

        @Override
        public void cmd(String string, int i) {
            
            
        }

        @Override
        public void cmd(String string, String string1) {
     
        }
    };
   
void showIndexScreen(){
workArea.removeAll();
        workArea.updateUI();
    Index pr=new Index(cmd); 
    workArea.add(pr,BorderLayout.CENTER); 
    workArea.updateUI();

}
void showStockScreen(){
workArea.removeAll();
        workArea.updateUI();
    Stock pr=new Stock(cmd); 
    workArea.add(pr,BorderLayout.CENTER); 
    workArea.updateUI();

}
void showHistoryScreen(){
workArea.removeAll();
        workArea.updateUI();
    History pr=new History(cmd); 
    workArea.add(pr,BorderLayout.CENTER); 
    workArea.updateUI();    workArea.updateUI();


}      
      
      
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        sms.Global_V.ADMIN=1; 
        abm.Security.adminID=1; 
    sms_library.C c=new sms_library.C() {

        @Override
        public void cmd(Object o) {
            
        }

        @Override
        public void cmd(String string) {
            JOptionPane.showMessageDialog(null, "Quetta");
        }

        @Override
        public void cmd(String string, Object o) {
            
        }

        @Override
        public void cmd(String string, int i) {
            
        }

        @Override
        public void cmd(String string, String string1) {
            
        }
        
        
        
    };
    
    
     Global_V.ADMIN=1; 
        Global_V.ADMIN_NAME="Pakistan"; 
        
        
       abm.Security.PERMISSIONS="fullaccess";//"reports:reports_view_status,reports_view_sale,reports_view_purchase,reports_view_stock_movement,reports_view_profit_and_loss,reports_view_ledger_balance,reports_view_balance_sheet;stock:stock_delete_products,stock_print_demand_list,stock_print_price_list,stock_edit_demand_list_values,stock_edit_product_name,stock_view_purchase_price,reports_view_stock_movement,stock_add_new_product,stock_view_available_quantity,stock_edit_product_price;";
        db.Database.printException=true; 
        db.Database.printQuery=true; 
        //System.out.println(db.Database.connect()); 
        //System.out.println(db.Database.connect("jdbc:derby://192.168.10.5:7500/TMS_Database","azeem","azeem")); 
        System.out.println(db.Database.connect("jdbc:derby://localhost:7500/TMS_Database","azeem","azeem")); 
        db.Database.printQuery=true; 
        abm.Global_V.LANGUAGE="English";
        abm.Global_V.preparteFonts();
        JFrame frame=new JFrame(); 
    frame.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
    frame.setDefaultCloseOperation(3);
    frame.setVisible(true);
    frame.setLayout(new BorderLayout());
    CDMS_Warehouse std=new CDMS_Warehouse(c); 
    frame.add(std,BorderLayout.CENTER); 
    frame.getRootPane().updateUI();
    }
    
        
        
    }
    

