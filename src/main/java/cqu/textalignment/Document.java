package cqu.textalignment;

/**
 * @author Deependra karki
 */
public class Document {

    private String formattedText;

    private String unformattedText = """
            The resulting design methodology is called Janus and is described in 
            Section 3. However, its efficacy will be greatly improved if the goal
            allocation process can occur in such a way that executable agent
            behaviours are generated, rather than paper-based specifications as in
            traditional Systems Engineering. In this regard, Janus is intended to
            be used in conjunction with the GORITE BDI framework [2]. Janus draws
            from various sources and case studies in the domain of agent-based
            manufacturing; this background material forms Section 2. In Section 4,
            the applicability of Janus to a quite different cyber-physical
            application, namely power substation automation, is examined. A
            discussion and concluding remarks are provided as Sections 5 and 6.
            """;

    public Document() {
    }

    public String getUnformattedText() {
        return unformattedText;
    }

}
