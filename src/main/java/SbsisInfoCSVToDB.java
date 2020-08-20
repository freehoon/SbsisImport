import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class SbsisInfoCSVToDB {
    public static void main(String[] args) throws IOException, SQLException, InterruptedException {
        String filePath = "/Users/freehoon/Documents/sbsis_201912/sbsis_201912_4.csv";
       // String filePath = "/Users/freehoon/Downloads/storage_201912/storage_201912_222.csv";
        List<SbsisDTO> lists = commonCSV1(filePath);

    //    System.out.println(lists.get(0));
    //    System.out.println(lists.get(1));

        SbsisDAO dao = new SbsisDAO();
        lists.remove(0);
        System.out.println("rows : " + lists.size());


        dao.insertSbsisInfo(lists);

    }

    private static List<SbsisDTO> commonCVS2(String filePath) throws IOException {
        System.out.println("CSV parse start....");
        long start = System.currentTimeMillis();

        CSVReader csvReader = new CSVReader(new FileReader(filePath));
        List<String[]> lists = csvReader.readAll();//new ArrayList<>();
        SbsisDTO dto = null;
        for(String[] list : lists){
            dto = new SbsisDTO();
            dto.setBizseId(list[0]);
            dto.setBizseNm(bizseNm);
            dto.setBrchNm(list[]);
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

    /*
    //csv 파일을 읽어 들여 List로 리턴
    public List<String[]> readerCSV(String filePath){ //파라미터 : 읽어들일 파일경로+파일명
        List<String[]> content = new ArrayList<String[]>();
        CSVReader reader = null;

        try {
            reader = new CSVReader(new FileReader(filePath));
            content = reader.readAll(); //전체 데이터를 가져옴.
            for(String[] data : content){

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(reader != null) reader.close();
            } catch (IOException e) {}
        }
        return content;
    }
    */

    private static List<SbsisDTO> commonCSV1(String filePath) throws IOException {
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
