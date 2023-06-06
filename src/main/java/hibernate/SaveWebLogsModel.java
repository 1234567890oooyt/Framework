package hibernate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Blob;

@Entity
@Table(name = "WebLogs")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class SaveWebLogsModel {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "Dom",length = 15000)
    private String Dom;

    @Column(name = "Logger")
    private String Logger;

}
