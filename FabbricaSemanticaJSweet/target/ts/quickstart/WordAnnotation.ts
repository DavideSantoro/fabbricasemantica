/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe che rappresenta la costruzione della pagina HTML di annotazione "wordAnnotation"
     * @class
     * @extends quickstart.AnnotationValidation
     */
    export class WordAnnotation extends quickstart.AnnotationValidation {
        /**
         * Stringa che indica l'URL della servlet a cui si vogliono inviare i dati
         */
        public static SERVLET_URL : string = "wordAnnotation.jsp";

        /**
         * Stringa che identifica il nome della task
         */
        public static TASK_NAME : string = "task=WORD_ANNOTATION";

        public static main(args : string[]) {
            let form1 : HTMLFormElement = quickstart.GestioneElementi.costruisciForm(WordAnnotation.SERVLET_URL, "5% 20%");
            let form2 : HTMLFormElement = quickstart.GestioneElementi.costruisciForm(quickstart.AnnotationValidation.RANDOM_URL_$LI$(), "-10% 67%");
            let description : HTMLLabelElement = document.createElement("label");
            $(description).css("font-style", "italic");
            let hiddenDescription : HTMLInputElement = quickstart.GestioneElementi.costruisciHidden("hiddenDescription");
            $.getJSON(quickstart.AnnotationValidation.REST_URL, WordAnnotation.TASK_NAME, ((hiddenDescription,description) => {
                return (result, a, ctx) => {
                    let json : JSON = <JSON>result;
                    let sDescription : string = <any>(json["description"]);
                    $(description).text(sDescription);
                    $(hiddenDescription).attr("value", sDescription);
                    return null;
                }
            })(hiddenDescription,description));
            $(form1).append(quickstart.GestioneElementi.divEtichetta(description), hiddenDescription, quickstart.GestioneElementi.costruisciTextArea("Tentare di associare alla definizione data la parola corrispondente", "150px", "770px"));
            AnnotationValidation.addLinksAndButtons(form1, form2, "5% 100%");
        }
    }
    WordAnnotation["__class"] = "quickstart.WordAnnotation";

}


quickstart.WordAnnotation.main(null);
