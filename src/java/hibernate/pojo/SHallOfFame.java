package hibernate.pojo;
// Generated Jun 13, 2015 12:19:47 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * SHallOfFame generated by hbm2java
 */
public class SHallOfFame  implements java.io.Serializable {


     private BigDecimal SId;
     private SUsers SUsers;
     private byte[] SPhoto;
     private BigDecimal SRank;

    public SHallOfFame() {
    }

    public SHallOfFame(BigDecimal SId, SUsers SUsers, byte[] SPhoto, BigDecimal SRank) {
       this.SId = SId;
       this.SUsers = SUsers;
       this.SPhoto = SPhoto;
       this.SRank = SRank;
    }
   
    public BigDecimal getSId() {
        return this.SId;
    }
    
    public void setSId(BigDecimal SId) {
        this.SId = SId;
    }
    public SUsers getSUsers() {
        return this.SUsers;
    }
    
    public void setSUsers(SUsers SUsers) {
        this.SUsers = SUsers;
    }
    public byte[] getSPhoto() {
        return this.SPhoto;
    }
    
    public void setSPhoto(byte[] SPhoto) {
        this.SPhoto = SPhoto;
    }
    public BigDecimal getSRank() {
        return this.SRank;
    }
    
    public void setSRank(BigDecimal SRank) {
        this.SRank = SRank;
    }




}


