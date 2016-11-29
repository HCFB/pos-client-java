package ru.homecredit.web.model.PosOnline;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by RRybasov on 08.09.2016.
 */
@Data
@NoArgsConstructor
public class ApplicationResponse {
    private String bankUrl;
    private ApplicationResourceDTO applicationResource;
}
