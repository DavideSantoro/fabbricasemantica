/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe che rappresenta la costruzione della pagina HTML di validazione "annotationValidation"
     * @class
     * @extends quickstart.AnnotationValidation
     */
    class TranslationAnnotation extends quickstart.AnnotationValidation {
        static main(args) {
            let form1 = quickstart.GestioneElementi.costruisciForm(TranslationAnnotation.SERVLET_URL, "5% 20%");
            let form2 = quickstart.GestioneElementi.costruisciForm(quickstart.AnnotationValidation.RANDOM_URL_$LI$(), "-10% 67%");
            let word = document.createElement("label");
            let description = document.createElement("label");
            $(description).css("font-style", "italic");
            let hiddenWord = quickstart.GestioneElementi.costruisciHidden("hiddenWord");
            let hiddenDescription = quickstart.GestioneElementi.costruisciHidden("hiddenDescription");
            $.getJSON(quickstart.AnnotationValidation.REST_URL, TranslationAnnotation.TASK_NAME, ((hiddenDescription, hiddenWord, description, word) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sWord = (json["word"]);
                    let sDescription = (json["description"]);
                    $(word).text(sWord);
                    $(description).text(sDescription);
                    $(hiddenWord).attr("value", sWord);
                    $(hiddenDescription).attr("value", sDescription);
                    return null;
                };
            })(hiddenDescription, hiddenWord, description, word));
            $(form1).append(quickstart.GestioneElementi.divEtichetta(word), quickstart.GestioneElementi.divEtichetta(description), hiddenWord, hiddenDescription, quickstart.GestioneElementi.costruisciTextArea("Fornire, nella propria lingua madre, una traduzione appropriata di tale parola e della sua definizione", "150px", "770px"));
            quickstart.AnnotationValidation.addLinksAndButtons(form1, form2, "5% 100%");
        }
    }
    /**
     * Stringa che indica l'URL della servlet a cui si vogliono inviare i dati
     */
    TranslationAnnotation.SERVLET_URL = "translationAnnotation.jsp";
    /**
     * Stringa che identifica il nome della task
     */
    TranslationAnnotation.TASK_NAME = "task=TRANSLATION_ANNOTATION";
    quickstart.TranslationAnnotation = TranslationAnnotation;
    TranslationAnnotation["__class"] = "quickstart.TranslationAnnotation";
})(quickstart || (quickstart = {}));
quickstart.TranslationAnnotation.main(null);
