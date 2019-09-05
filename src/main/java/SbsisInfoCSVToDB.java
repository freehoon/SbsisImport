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
        String filePath = "D:\\소상공 데이터\\소상공인시장진흥공단_상가업소정보_201906\\sbsis_201906_01.csv";

        List<SbsisDTO> lists = commonCSV(filePath);

        System.out.println(lists.get(0));
        System.out.println(lists.get(1));

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
            dto.setLnoCd(record.get(19));
            dto.setPlotSctCd(record.get(20));
            dto.setPlotSctNm(record.get(21));
            dto.setLnoMnno(record.get(22));
            dto.setLnoSlno(record.get(23));
            dto.setLnoAdr(record.get(24));
            dto.setRdnmCd(record.get(25));
            dto.setRdnm(record.get(26));
            dto.setBldMnno(record.get(27));
            dto.setBldSlno(record.get(28));
            dto.setBldMngNo(record.get(29));
            dto.setBldNm(bldNm);
            dto.setRdnmAdr(record.get(31));
            dto.setOldZipcd(record.get(32));
            dto.setNewZipcd(record.get(33));
            dto.setDongNo(record.get(34));
            dto.setFlrNo(record.get(35));
            dto.setHoNo(record.get(36));
            dto.setLon(record.get(37));
            dto.setLat(record.get(38));

            lists.add(dto);
        //    i++;
        //    if(i > 100) break;
        }
        System.out.println("CSV parse end....");

        long end = System.currentTimeMillis();
        System.out.println("실행시간 : " + (end - start)/1000 + " 초");

        return lists;
    }


}
