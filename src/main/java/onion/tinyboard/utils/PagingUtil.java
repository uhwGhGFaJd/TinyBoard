package onion.tinyboard.utils;

import org.springframework.stereotype.Component;

@Component
public class PagingUtil {

    public String getPaging(int current_page, int total_page, String list_url) {
        StringBuilder sb = new StringBuilder();

        int numPerBlock = 10;

        if (current_page < 1 || total_page < 1) {
            return "";
        }

        if (list_url.contains("?")) {
            list_url += "&";
        } else {
            list_url += "?";
        }

        int currentPageSetup = (current_page / numPerBlock) * numPerBlock;
        if (current_page % numPerBlock == 0) {
            currentPageSetup = currentPageSetup - numPerBlock;
        }

        sb.append("<nav class='d-sm-flex justify-content-sm-between align-items-sm-center text-center'>");
        sb.append("<ul class='pagination pagination-sm justify-content-center justify-content-sm-end'>");

        int n = current_page - numPerBlock;

        if (total_page > numPerBlock && currentPageSetup > 0) {
            sb.append("<li class='page-item'><a class='page-link' href='").append(list_url).append("page=").append(n).append("' aria-label='Previous'>Previous</a></li>");
        } else {
            sb.append("<li class='page-item disabled'><a class='page-link' href='#' aria-label='First'>Previous</a></li>");
        }

        int page = currentPageSetup + 1;
        while (page <= total_page && page <= (currentPageSetup + numPerBlock)) {
            if (page == current_page) {
                sb.append("<li class='page-item active'><a class='page-link' href='#'>").append(page).append("</a></li>");
            } else {
                sb.append("<li class='page-item'><a class='page-link' href='").append(list_url).append("page=").append(page).append("'>").append(page).append("</a></li>");
            }
            page++;
        }

        n = current_page + numPerBlock;
        if (n > total_page) n = total_page;
        if (total_page - currentPageSetup > numPerBlock) {
            sb.append("<li class='page-item'><a class='page-link' href='").append(list_url).append("page=").append(n).append("' aria-label='Next'>Next</a></li>");
        } else {
            sb.append("<li class='page-item disabled'><a class='page-link' href='#' aria-label='Next'>Next</a></li>");
        }

        sb.append("</ul>");
        sb.append("</nav>");
        return sb.toString();
    }

    public int pageCount(int numPerPage, int dataCount) {
        int pageCount = 0;

        if (dataCount > 0) {
            if (dataCount % numPerPage == 0) {
                pageCount = dataCount / numPerPage;
            } else {
                pageCount = dataCount / numPerPage + 1;
            }
        }
        return pageCount;
    }
}
