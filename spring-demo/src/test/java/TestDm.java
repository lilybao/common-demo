import org.apache.tomcat.util.http.fileupload.FileUtils;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * @program: common-demo
 * @description:
 * @author: li baojian
 * @create: 2020-03-18 10:57
 */
public class TestDm {
    public static void main(String[] args) {
        try {
            PreparedStatement pstmt;
            String driver = "dm.jdbc.driver.DmDriver";// "com.ibm.db2.jcc.DB2Driver";
            String url = "jdbc:dm://192.168.0.195:12345/AUDITLOCAL";//"jdbc:dm://10.70.0.4:12345/AUDITLOCAL";// "jdbc:db2://192.168.0.168:50001/";
            Connection conn = null;
            ResultSet rs;
            //加载驱动
            Class.forName(driver).newInstance();
//            String sql = "select * from AUDITRESULT.VIEW_DOC_DEAL_CONTENT WHERE DOCUUID IN (select DOCUUID from AUDITRESULT.AUDIT_DECISION WHERE PROJECTNAME LIKE '%经济责任审计%')";
//            String sql = "select * from AUDITRESULT.VIEW_DOC_DEAL_CONTENT WHERE DOCUUID IN (select DOCUUID from AUDITRESULT.AUDIT_DECISION WHERE PROJECTNAME LIKE '%经济责任审计%')";
//            String sql = "select AUDITRESULT.VIEW_DOC_DEAL_CONTENT.*,AUDITRESULT.AUDIT_DECISION.PROJECTNAME from AUDITRESULT.VIEW_DOC_DEAL_CONTENT left join AUDITRESULT.AUDIT_DECISION on  AUDITRESULT.VIEW_DOC_DEAL_CONTENT.DOCUUID=AUDITRESULT.AUDIT_DECISION.DOCUUID WHERE AUDITRESULT.AUDIT_DECISION.PROJECTNAME LIKE '%经济责任审计%'";
//            String sql = "  select ddc.DOCUUID,OFFICIALNAME,OFFICIAL from (\n" +
//                    "     select DOCUUID,MAX(OFFICIALVERSION ) OFFICIALVERSION from DOCMANAGE.DOC_DEAL_CONTENT where   VERSION_TYPE IS NOT NULL AND DOCUUID in (select  distinct DOCUUID from DOCMANAGE.DOC_DEAL_DOCUMENT  where TITLE LIKE '%办事处%' )\n" +
//                    "   GROUP BY DOCUUID)s left join DOCMANAGE.DOC_DEAL_CONTENT ddc on s.DOCUUID=ddc.DOCUUID and s.OFFICIALVERSION=ddc.OFFICIALVERSION\n" +
//                    "   ";

//            String sql="select DOCMANAGE.DOC_DEAL_DOCUMENT.TITLE  OFFICIALNAME,DOCMANAGE.DOC_DEAL_CONTENT.OFFICIAL,DOCMANAGE.DOC_DEAL_CONTENT.DOCUUID from DOCMANAGE.DOC_DEAL_DOCUMENT left join DOCMANAGE.DOC_DEAL_CONTENT ON \n" +
//                    " DOCMANAGE.DOC_DEAL_DOCUMENT.DOCUUID=DOCMANAGE.DOC_DEAL_CONTENT.DOCUUID\n" +
//                    "   where DOCMANAGE.DOC_DEAL_DOCUMENT.TITLE LIKE '%县长%' and DOCMANAGE.DOC_DEAL_CONTENT.OFFICIALNAME is not null\n" +
//                    "  ";

//            String sql="select DOCMANAGE.DOC_DEAL_DOCUMENT.TITLE  OFFICIALNAME,DOCMANAGE.DOC_DEAL_CONTENT.OFFICIAL,DOCMANAGE.DOC_DEAL_CONTENT.DOCUUID from DOCMANAGE.DOC_DEAL_DOCUMENT left join DOCMANAGE.DOC_DEAL_CONTENT ON \n" +
//                    "                     DOCMANAGE.DOC_DEAL_DOCUMENT.DOCUUID=DOCMANAGE.DOC_DEAL_CONTENT.DOCUUID\n" +
//                    "                       where DOCMANAGE.DOC_DEAL_DOCUMENT.TITLE LIKE '%县长%' and DOCMANAGE.DOC_DEAL_CONTENT.OFFICIALNAME is not null";


//            String sql = "select * from DOCMANAGE.DOC_DEAL_CONTENT where OFFICIALNAME like '%经济责任审计工作方案%'";
//            String sql = "select * from DOCMANAGE.DOC_DEAL_CONTENT where OFFICIALNAME like '%河南省省级预算单位%'";
//            String sql = "select * from DOCMANAGE.DOC_TRAN_CONTENT where OFFICIALNAME like '%河南省省级预算单位%'";
            String sql = "select * from DOCMANAGE.DOC_READ_DOCCONTENT where DOC_FILENAME like '%河南省省级预算单位%'";
            //获得连接
            conn = DriverManager.getConnection(url, "DOCMANAGE", "pass1009");
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            ArrayList<Resport> list = new ArrayList<>();
            while (rs.next()) {
                Resport resport = new Resport();
                resport.setId(rs.getString("DOCUUID"));
                resport.setName(rs.getString("OFFICIALNAME"));
                resport.setContent(rs.getBlob("OFFICIAL"));
                list.add(resport);

            }

            for (int i = 0; i < list.size(); i++) {
                FileOutputStream fileOutputStream=null;
                InputStream inputStream=null;
                Resport resport1 = list.get(i);
                try {
                    inputStream = resport1.getContent().getBinaryStream();
                    File file = new File("d://审计对象//" + resport1.getName() + ".doc");
                    if(!file.exists()){
                        fileOutputStream = new FileOutputStream(file);
                        int len = 0;
                        byte[] bytes = new byte[1024];
                        while ((len = inputStream.read(bytes)) != -1) {
                            fileOutputStream.write(bytes, 0, len);
                        }
                        fileOutputStream.flush();
                    }

                } catch (IOException e) {
                    continue;
                } finally {
                    try {
                        if(fileOutputStream!=null){
                            fileOutputStream.close();
                        }
                        if(inputStream!=null){
                            inputStream.close();
                        }


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static class Resport {
        private String id;
        private String name;
        private Blob content;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Blob getContent() {
            return content;
        }

        public void setContent(Blob content) {
            this.content = content;
        }
    }
}
