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
        //List<SbsisDTO> lists = commonCSV2(filePath);

    //    System.out.println(lists.get(0));
    //    System.out.println(lists.get(1));

        SbsisDAO dao = new SbsisDAO();
        lists.remove(0);
        System.out.println("rows : " + lists.size());


        dao.insertSbsisInfo(lists);

    }

    private static List<SbsisDTO> commonCSV2(String filePath) throws IOException {
        System.out.println("CSV parse start....");
        long start = System.currentTimeMillis();

        CSVReader csvReader = new CSVReader(new FileReader(filePath));
        List<String[]> lists = csvReader.readAll();//new ArrayList<>();
        SbsisDTO dto;
        List<SbsisDTO> sbsisDTOList = new ArrayList<>();

        for(String[] list : lists){
            String bizseNm = list[1].replace("\\", "\\\\");
            bizseNm = bizseNm.replace("'", "\\'");

            String lnoCd = list[19].replace("\"", "");

            String bldMngNo = list[29].replace("\"", "");

            String bldNm = list[30].replace("\\", "\\\\");
            bldNm = bldNm.replace("'", "\\'");

            String newZipcd = list[33].replace("\"", "");

            String lon = list[37].replace("\"", "");

            String lat = list[38].replace("\"", "");

            dto = new SbsisDTO();
            dto.setBizseId(list[0]);
            dto.setBizseNm(bizseNm);
            dto.setBrchNm(list[2]);
            dto.setIndsLclsCd(list[3]);
            dto.setIndsLclsNm(list[4]);
            dto.setIndsMclsCd(list[5]);
            dto.setIndsMclsNm(list[6]);
            dto.setIndsSclsCd(list[7]);
            dto.setIndsSclsNm(list[8]);
            dto.setKsicCd(list[9]);
            dto.setKsicNm(list[10]);
            dto.setCtprvnCd(list[11]);
            dto.setCtprvnNm(list[12]);
            dto.setSignguCd(list[13]);
            dto.setSignguNm(list[14]);
            dto.setAdongCd(list[15]);
            dto.setAdongNm(list[16]);
            dto.setLdongCd(list[17]);
            dto.setLdongNm(list[18]);
            //dto.setLnoCd(record.get(19));
            dto.setLnoCd(lnoCd);
            dto.setPlotSctCd(list[20]);
            dto.setPlotSctNm(list[21]);
            dto.setLnoMnno(list[22]);
            dto.setLnoSlno(list[23]);
            dto.setLnoAdr(list[24]);
            dto.setRdnmCd(list[25] + "");
            dto.setRdnm(list[26]);
            dto.setBldMnno(list[27]);
            dto.setBldSlno(list[28]);
            //dto.setBldMngNo(record.get(29));
            dto.setBldMngNo(bldMngNo);
            dto.setBldNm(bldNm);
            dto.setRdnmAdr(list[31]);
            dto.setOldZipcd(list[32]);
            //dto.setNewZipcd(record.get(33));
            dto.setNewZipcd(newZipcd);
            dto.setDongNo(list[34]);
            dto.setFlrNo(list[35]);
            dto.setHoNo(list[36]);
            dto.setLon(lon);
            dto.setLat(lat);
            dto.setFclty_loc(lon + " " + lat);
            //dto.setLat(record.get(39));

            sbsisDTOList.add(dto);
            //    i++;
            //    if(i > 100) break;
        }
        System.out.println("CSV parse end....");

        long end = System.currentTimeMillis();
        System.out.println("CSV 파일 읽는데 걸린 시간 : " + (end - start)/1000 + " 초");

        return sbsisDTOList;
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
        List<SbsisDTO> lists = new ArrayList<>();

        Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
     //   int i = 0;
        for(CSVRecord record : records){
            SbsisDTO dto = new SbsisDTO();

            String bizseNm = record.get(1).replace("\\", "\\\\");
            bizseNm = bizseNm.replace("'", "\\'");

            String bldNm = record.get(30).replace("\\", "\\\\");
            bldNm = bldNm.replace("'", "\\'");

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
            dto.setRdnmCd(record.get(25) + "");
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
