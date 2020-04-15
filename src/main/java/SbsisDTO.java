import lombok.Data;

@Data
public class SbsisDTO {
    // 1. 상가업소번호
    String bizseId;

    // 2. 상호명
    String bizseNm;

    // 3. 지점명
    String brchNm;

    // 4. 상권업종대분류코드
    String indsLclsCd;

    // 5. 상권업종대분류명
    String indsLclsNm;

    // 6. 상권업종중분류코드
    String indsMclsCd;

    // 7. 상권업종중분류명
    String indsMclsNm;

    // 8. 상권업종소분류코드
    String indsSclsCd;

    // 9. 상권업종소분류명
    String indsSclsNm;

    // 10. 표준산업분류코드
    String ksicCd;

    // 11. 표준산업분류명
    String ksicNm;

    // 12. 시도코드
    String ctprvnCd;

    // 13. 시도명
    String ctprvnNm;

    // 14. 시군구코드
    String signguCd;

    // 15. 시군구명
    String signguNm;

    // 16. 행정동코드
    String adongCd;

    // 17. 행정동명
    String adongNm;

    // 18. 법정동코드
    String ldongCd;

    // 19.법정동명
    String ldongNm;

    // 20. 지번코드(PNU)
    String lnoCd;

    // 21. 대지구분코드
    String plotSctCd;

    // 22. 대지구분명
    String plotSctNm;

    // 23. 지번본번지
    String lnoMnno;

    // 24. 지번부번지
    String lnoSlno;

    // 25. 지번주소
    String lnoAdr;

    // 26. 도로명코드
    String rdnmCd;

    // 27. 도로명
    String rdnm;

    // 28. 건물본번지
    String bldMnno;

    // 29. 건물부번지
    String bldSlno;

    // 30. 건물관리번호
    String bldMngNo;

    // 31. 건물명
    String bldNm;

    // 32. 도로명주소
    String rdnmAdr;

    // 33. 구우편번호
    String oldZipcd;

    // 34. 신우편번호
    String newZipcd;

    // 35. 동정보
    String dongNo;

    // 36. 층정보
    String flrNo;

    // 37. 호정보
    String hoNo;

    // 38. 경도
    String lon;

    // 39. 위도
    String lat;

    // 40. 경도위도
    String fclty_loc;
}
