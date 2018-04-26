package friendsofmine.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class Article {

    @PositiveOrZero
    private int id ;

    @NotNull
    @Size(min = 1,max = 255)
    private String titre;

    private String categorie;
    public Article(int i, String s, String s1) {
        this.id = i;
        this.titre = s;
        this.categorie = s1;
    }
}
