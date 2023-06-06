package hibernate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ApiLogs")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class SaveApiLogsModel {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "response",length = 5000)
    private String response;

    @Column(name = "statusCode")
    private Integer statusCode;

}
