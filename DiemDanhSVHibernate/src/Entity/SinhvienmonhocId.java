package Entity;
// Generated Aug 17, 2017 7:16:05 AM by Hibernate Tools 4.3.1



/**
 * SinhvienmonhocId generated by hbm2java
 */
public class SinhvienmonhocId  implements java.io.Serializable {


     private String maSv;
     private String maMh;

    public SinhvienmonhocId() {
    }

    public SinhvienmonhocId(String maSv, String maMh) {
       this.maSv = maSv;
       this.maMh = maMh;
    }
   
    public String getMaSv() {
        return this.maSv;
    }
    
    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }
    public String getMaMh() {
        return this.maMh;
    }
    
    public void setMaMh(String maMh) {
        this.maMh = maMh;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SinhvienmonhocId) ) return false;
		 SinhvienmonhocId castOther = ( SinhvienmonhocId ) other; 
         
		 return ( (this.getMaSv()==castOther.getMaSv()) || ( this.getMaSv()!=null && castOther.getMaSv()!=null && this.getMaSv().equals(castOther.getMaSv()) ) )
 && ( (this.getMaMh()==castOther.getMaMh()) || ( this.getMaMh()!=null && castOther.getMaMh()!=null && this.getMaMh().equals(castOther.getMaMh()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getMaSv() == null ? 0 : this.getMaSv().hashCode() );
         result = 37 * result + ( getMaMh() == null ? 0 : this.getMaMh().hashCode() );
         return result;
   }   


}


