import java.sql.*;
import java.util.Iterator;
import java.util.List;

public class SbsisDAO {
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://localhost:3306/table_Name?useSSL=false";
    static final String USERNAME = "root";
    static final String PASSWORD = "qwerqwer";

    private Connection conn = null;
    private Statement state = null;
    private ResultSet rs = null;


    public SbsisDAO() throws SQLException {
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(conn != null) conn.close();
        }
    }

    public void insertSbsisInfo(List<SbsisDTO> lists) throws InterruptedException {
        System.out.println("DB insert start....");
        long start = System.currentTimeMillis();

        Iterator iter = lists.iterator();
        StringBuilder strSql = new StringBuilder();
        strSql.append("INSERT INTO storage3 (bizesId, bizesNm, brchNm, indsLclsCd, indsMclsCd, indsSclsCd, ksicCd, ctprvnCd, signguCd, adongCd, ldongCd, lnoCd, plotSctCd, lnoMnno, lnoSlno, lnoAdr, rdnm, bldMnno, bldSlno, bldMngNo, bldNm, rdnmAdr, oldZipcd, newZipcd, dongNo, flrNo, hoNo, lon, lat, fclty_loc) VALUES");
        int cnt = 0;
        while(iter.hasNext()){
            SbsisDTO dto = (SbsisDTO) iter.next();
            strSql.append("(");
            strSql.append( "'" + dto.getBizseId() + "'," );
            strSql.append( "'" + dto.getBizseNm() + "',");
            strSql.append( "'" + dto.getBrchNm() + "',");
            strSql.append( "'" + dto.getIndsLclsCd() + "',");
            //strSql.append( "'" + dto.getIndsLclsNm() + "',");
            strSql.append( "'" + dto.getIndsMclsCd() + "',");
            //strSql.append( "'" + dto.getIndsMclsNm() + "',");
            strSql.append( "'" + dto.getIndsSclsCd() + "',");
            //strSql.append( "'" + dto.getIndsSclsNm() + "',");
            strSql.append( "'" + dto.getKsicCd() + "',");
            //strSql.append( "'" + dto.getKsicNm() + "',");
            strSql.append( "'" + dto.getCtprvnCd() + "',");
            //strSql.append( "'" + dto.getCtprvnNm() + "',");
            strSql.append( "'" + dto.getSignguCd() + "',");
            //strSql.append( "'" + dto.getSignguNm() + "',");
            strSql.append( "'" + dto.getAdongCd() + "',");
            //strSql.append( "'" + dto.getAdongNm() + "',");
            strSql.append( "'" + dto.getLdongCd() + "',");
            //strSql.append( "'" + dto.getLdongNm() + "',");
            strSql.append( "'" + dto.getLnoCd() + "',");
            strSql.append( "'" + dto.getPlotSctCd() + "',");
            //strSql.append( "'" + dto.getPlotSctNm() + "',");
            strSql.append( "'" + dto.getLnoMnno() + "',");
            strSql.append( "'" + dto.getLnoSlno() + "',");
            strSql.append( "'" + dto.getLnoAdr() + "',");
            //strSql.append( "'" + dto.getRdnmCd() + "',");
            strSql.append( "'" + dto.getRdnm() + "',");
            strSql.append( "'" + dto.getBldMnno() + "',");
            strSql.append( "'" + dto.getBldSlno() + "',");
            strSql.append( "'" + dto.getBldMngNo() + "',");
            strSql.append( "'" + dto.getBldNm() + "',");
            strSql.append( "'" + dto.getRdnmAdr() + "',");
            strSql.append( "'" + dto.getOldZipcd() + "',");
            strSql.append( "'" + dto.getNewZipcd() + "',");
            strSql.append( "'" + dto.getDongNo() + "',");
            strSql.append( "'" + dto.getFlrNo() + "',");
            strSql.append( "'" + dto.getHoNo() + "',");
            strSql.append( "'" + dto.getLon() + "',");
            strSql.append( "'" + dto.getLat() + "',");
            strSql.append( "ST_GeomFromText('point(" + dto.getFclty_loc() + ")'))");

            cnt++;

            if(cnt == 4999 || !iter.hasNext())
                strSql.append(";");
            else
                strSql.append(",");


            if(cnt == 4999 || !iter.hasNext()){
                System.out.println(strSql);
                try{
                    Class.forName(JDBC_DRIVER);
                    conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                    state = conn.createStatement();
                    state.executeUpdate(strSql.toString());

                    state.close();
                    conn.close();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                Thread.sleep(3000);
                strSql.setLength(0);
                strSql.append("INSERT INTO storage3 (bizesId, bizesNm, brchNm, indsLclsCd, indsMclsCd, indsSclsCd, ksicCd, ctprvnCd, signguCd, adongCd, ldongCd, lnoCd, plotSctCd, lnoMnno, lnoSlno, lnoAdr, rdnm, bldMnno, bldSlno, bldMngNo, bldNm, rdnmAdr, oldZipcd, newZipcd, dongNo, flrNo, hoNo, lon, lat, fclty_loc) VALUES");
                cnt = 0;

            }

        }



        System.out.println("DB insert end....");
        long end = System.currentTimeMillis();
        System.out.println("DB 입력에 걸린 시간 : " + (end - start)/1000 + " 초");
    }
}
