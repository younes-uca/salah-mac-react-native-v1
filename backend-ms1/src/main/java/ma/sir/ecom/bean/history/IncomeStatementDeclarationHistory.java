package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "income_statement_declaration")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="income_statement_declaration_seq",sequenceName="income_statement_declaration_seq",allocationSize=1, initialValue = 1)
public class IncomeStatementDeclarationHistory extends HistBusinessObject  {


    public IncomeStatementDeclarationHistory() {
    super();
    }

    public IncomeStatementDeclarationHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="income_statement_declaration_seq")
    public Long getId() {
    return id;
    }
}

