/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe che rappresenta la costruzione della pagina HTML di annotazione "wordAnnotation"
     * @class
     * @extends quickstart.AnnotationValidation
     */
    class WordAnnotation extends quickstart.AnnotationValidation {
        static main(args) {
            let form1 = quickstart.GestioneElementi.costruisciForm(WordAnnotation.SERVLET_URL, "5% 20%");
            let form2 = quickstart.GestioneElementi.costruisciForm(quickstart.AnnotationValidation.RANDOM_URL_$LI$(), "-10% 67%");
            let description = document.createElement("label");
            $(description).css("font-style", "italic");
            let hiddenDescription = quickstart.GestioneElementi.costruisciHidden("hiddenDescription");
            $.getJSON(quickstart.AnnotationValidation.REST_URL, WordAnnotation.TASK_NAME, ((hiddenDescription, description) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sDescription = (json["description"]);
                    $(description).text(sDescription);
                    $(hiddenDescription).attr("value", sDescription);
                    return null;
                };
            })(hiddenDescription, description));
            $(form1).append(quickstart.GestioneElementi.divEtichetta(description), hiddenDescription, quickstart.GestioneElementi.costruisciTextArea("Tentare di associare alla definizione data la parola corrispondente", "150px", "770px"));
            quickstart.AnnotationValidation.addLinksAndButtons(form1, form2, "5% 100%");
        }
    }
    /**
     * Stringa che indica l'URL della servlet a cui si vogliono inviare i dati
     */
    WordAnnotation.SERVLET_URL = "wordAnnotation.jsp";
    /**
     * Stringa che identifica il nome della task
     */
    WordAnnotation.TASK_NAME = "task=WORD_ANNOTATION";
    quickstart.WordAnnotation = WordAnnotation;
    WordAnnotation["__class"] = "quickstart.WordAnnotation";
})(quickstart || (quickstart = {}));
quickstart.WordAnnotation.main(null);
