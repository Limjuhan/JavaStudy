package Mission;

public class Prac_03 {
    public static void html(long totalCount, long pageIndex) {
        int countList = 10;//한 페이지에 보여줄 글 갯수
        int countPage = 10;// 페이지 갯수 [1] [2]....
        long block = totalCount / countList;
        if (totalCount % countList != 0) {
            block++;
        }
        long startPage = ((pageIndex - 1) / 10) * 10 + 1;
        long endPage = startPage + countPage - 1;
        if (endPage > block) {
            endPage = block;
        }

        System.out.println("<a href='#'>[처음]</a>");
        System.out.println("<a href='#'>[이전]</a>");

        System.out.println("<a href='#' class='on'>"+pageIndex+"</a>");
        for (int i = (int)startPage; i <= endPage; i++) {
            System.out.println("<a href='#'>"+i+"</a>");
        }

        System.out.println("<a href='#'>[다음]</a>");
        System.out.println("<a href='#'>[마지막]</a>");
    }

    public static void main(String[] args) {
        long totalCount = 1027;
        long pageIndex = 11;
        html(totalCount, pageIndex);

    }
}
