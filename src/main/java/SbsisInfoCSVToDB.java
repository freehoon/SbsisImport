import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class SbsisInfoCSVToDB {
    public static void main(String[] args) throws IOException, SQLException, InterruptedException {
        String filePath = "/Users/freehoon/Documents/sbsis_201912/sbsis_201912_1.csv";
       // String filePath = "/Users/freehoon/Downloads/storage_201912/storage_201912_222.csv";
        List<SbsisDTO> lists = commonCSV(filePath);

    //    System.out.println(lists.get(0));
    //    System.out.println(lists.get(1));

        SbsisDAO dao = new SbsisDAO();
        lists.remove(0);
        System.out.println("rows : " + lists.size());


        dao.insertSbsisInfo(lists);

    }

    private static List<SbsisDTO> commonCSV(String filePath) throws IOException {
        System.out.println("CSV parse start....");
        long start = System.currentTimeMillis();

        Reader in = new FileReader(filePath);
        List<SbsisDTO> lists = new ArrayList<SbsisDTO>();

        Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
     //   int i = 0;
        for(CSVRecord record : records){
            SbsisDTO dto = new SbsisDTO();

            String bizseNm = record.get(1).replace("\\", "\\\\");
            bizseNm = bizseNm.replace("\'", "\\\'");

            String bldNm = record.get(30).replace("\\", "\\\\");
            bldNm = bldNm.replace("\'", "\\\'");

            String lnoCd = record.get(19).replace("\"", "");

            String bldMngNo = record.get(29).replace("\"", "");

            String newZipcd = record.get(33).replace("\"", "");

            String lon = record.get(37).replace("\"", "");

            String lat = record.get(38).replace("\"", "");

            dto.setBizseId(record.get(0));
            dto.setBizseNm(bizseNm);
            dto.setBrchNm(record.get(2));
            dto.setIndsLclsCd(record.get(3));
            dto.setIndsLclsNm(record.get(4));
            dto.setIndsMclsCd(record.get(5));
            dto.setIndsMclsNm(record.get(6));
            dto.setIndsSclsCd(record.get(7));
            dto.setIndsSclsNm(record.get(8));
            dto.setKsicCd(record.get(9));
            dto.setKsicNm(record.get(10));
            dto.setCtprvnCd(record.get(11));
            dto.setCtprvnNm(record.get(12));
            dto.setSignguCd(record.get(13));
            dto.setSignguNm(record.get(14));
            dto.setAdongCd(record.get(15));
            dto.setAdongNm(record.get(16));
            dto.setLdongCd(record.get(17));
            dto.setLdongNm(record.get(18));
            //dto.setLnoCd(record.get(19));
            dto.setLnoCd(lnoCd);
            dto.setPlotSctCd(record.get(20));
            dto.setPlotSctNm(record.get(21));
            dto.setLnoMnno(record.get(22));
            dto.setLnoSlno(record.get(23));
            dto.setLnoAdr(record.get(24));
            dto.setRdnmCd(record.get(25).toString() + "");
            dto.setRdnm(record.get(26));
            dto.setBldMnno(record.get(27));
            dto.setBldSlno(record.get(28));
            //dto.setBldMngNo(record.get(29));
            dto.setBldMngNo(bldMngNo);
            dto.setBldNm(bldNm);
            dto.setRdnmAdr(record.get(31));
            dto.setOldZipcd(record.get(32));
            //dto.setNewZipcd(record.get(33));
            dto.setNewZipcd(newZipcd);
            dto.setDongNo(record.get(34));
            dto.setFlrNo(record.get(35));
            dto.setHoNo(record.get(36));
            dto.setLon(lon);
            dto.setLat(lat);
            dto.setFclty_loc(lon + " " + lat);
            //dto.setLat(record.get(39));

            lists.add(dto);
        //    i++;
        //    if(i > 100) break;
        }
        System.out.println("CSV parse end....");

        long end = System.currentTimeMillis();
        System.out.println("CSV 파일 읽는데 걸린 시간 : " + (end - start)/1000 + " 초");

        return lists;
    }


}
