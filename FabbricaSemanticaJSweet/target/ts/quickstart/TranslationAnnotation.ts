/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe che rappresenta la costruzione della pagina HTML di validazione "annotationValidation"
     * @class
     * @extends quickstart.AnnotationValidation
     */
    export class TranslationAnnotation extends quickstart.AnnotationValidation {
        /**
         * Stringa che indica l'URL della servlet a cui si vogliono inviare i dati
         */
        public static SERVLET_URL : string = "translationAnnotation.jsp";

        /**
         * Stringa che identifica il nome della task
         */
        public static TASK_NAME : string = "task=TRANSLATION_ANNOTATION";

        public static main(args : string[]) {
            let form1 : HTMLFormElement = quickstart.GestioneElementi.costruisciForm(TranslationAnnotation.SERVLET_URL, "5% 20%");
            let form2 : HTMLFormElement = quickstart.GestioneElementi.costruisciForm(quickstart.AnnotationValidation.RANDOM_URL_$LI$(), "-10% 67%");
            let word : HTMLLabelElement = document.createElement("label");
            let description : HTMLLabelElement = document.createElement("label");
            $(description).css("font-style", "italic");
            let hiddenWord : HTMLInputElement = quickstart.GestioneElementi.costruisciHidden("hiddenWord");
            let hiddenDescription : HTMLInputElement = quickstart.GestioneElementi.costruisciHidden("hiddenDescription");
            $.getJSON(quickstart.AnnotationValidation.REST_URL, TranslationAnnotation.TASK_NAME, ((hiddenDescription,hiddenWord,description,word) => {
                return (result, a, ctx) => {
                    let json : JSON = <JSON>result;
                    let sWord : string = <any>(json["word"]);
                    let sDescription : string = <any>(json["description"]);
                    $(word).text(sWord);
                    $(description).text(sDescription);
                    $(hiddenWord).attr("value", sWord);
                    $(hiddenDescription).attr("value", sDescription);
                    return null;
                }
            })(hiddenDescription,hiddenWord,description,word));
            $(form1).append(quickstart.GestioneElementi.divEtichetta(word), quickstart.GestioneElementi.divEtichetta(description), hiddenWord, hiddenDescription, quickstart.GestioneElementi.costruisciTextArea("Fornire, nella propria lingua madre, una traduzione appropriata di tale parola e della sua definizione", "150px", "770px"));
            AnnotationValidation.addLinksAndButtons(form1, form2, "5% 100%");
        }
    }
    TranslationAnnotation["__class"] = "quickstart.TranslationAnnotation";

}


quickstart.TranslationAnnotation.main(null);
