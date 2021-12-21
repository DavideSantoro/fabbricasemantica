/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe che rappresenta la costruzione della pagina HTML di annotazione "myAnnotation"
     * @class
     * @extends quickstart.AnnotationValidation
     */
    class MyAnnotation extends quickstart.AnnotationValidation {
        static main(args) {
            let form1 = quickstart.GestioneElementi.costruisciForm(MyAnnotation.SERVLET_URL, "5% 23%");
            let form2 = quickstart.GestioneElementi.costruisciForm(quickstart.AnnotationValidation.RANDOM_URL_$LI$(), "-10.5% 75%");
            let richiesta = quickstart.GestioneElementi.costruisciEtichetta("Comporre la parola associata alla definizione trascinando le lettere nei riquadri bianchi all\'interno dei riquadri blu");
            $(richiesta).css("font-weight", "bold").css("white-space", "nowrap");
            let description = document.createElement("label");
            $(description).css("font-style", "italic");
            let divPrimaLettera = quickstart.GestioneElementi.costruisciDrag();
            let divSecondaLettera = quickstart.GestioneElementi.costruisciDrag();
            let divTerzaLettera = quickstart.GestioneElementi.costruisciDrag();
            let divQuartaLettera = quickstart.GestioneElementi.costruisciDrag();
            let divQuintaLettera = quickstart.GestioneElementi.costruisciDrag();
            let arrayInteri = [0, 1, 2, 3, 4];
            for (let i = 4; i > 0; i--) {
                {
                    let randomInt = (Math.floor(Math.random() * i) | 0);
                    let lastInt = arrayInteri[i];
                    arrayInteri[i] = arrayInteri[randomInt];
                    arrayInteri[randomInt] = lastInt;
                }
                ;
            }
            $.getJSON(quickstart.AnnotationValidation.REST_URL, MyAnnotation.TASK_NAME, ((divTerzaLettera, divQuintaLettera, description, arrayInteri, divQuartaLettera, divPrimaLettera, divSecondaLettera) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sWord = (json["word"]);
                    let sDescription = (json["description"]);
                    $(description).text(sDescription);
                    $(divPrimaLettera).text(sWord.charAt(arrayInteri[0]) + "");
                    $(divSecondaLettera).text(sWord.charAt(arrayInteri[1]) + "");
                    $(divTerzaLettera).text(sWord.charAt(arrayInteri[2]) + "");
                    $(divQuartaLettera).text(sWord.charAt(arrayInteri[3]) + "");
                    $(divQuintaLettera).text(sWord.charAt(arrayInteri[4]) + "");
                    return null;
                };
            })(divTerzaLettera, divQuintaLettera, description, arrayInteri, divQuartaLettera, divPrimaLettera, divSecondaLettera));
            let divSpazio = document.createElement("div");
            $(divSpazio).css("height", "5px");
            $(divSpazio).css("width", "90px");
            $(divSpazio).css("margin", "5% 10%");
            let hiddenInput1 = quickstart.GestioneElementi.costruisciHidden("hidden1");
            let hiddenInput2 = quickstart.GestioneElementi.costruisciHidden("hidden2");
            let hiddenInput3 = quickstart.GestioneElementi.costruisciHidden("hidden3");
            let hiddenInput4 = quickstart.GestioneElementi.costruisciHidden("hidden4");
            let hiddenInput5 = quickstart.GestioneElementi.costruisciHidden("hidden5");
            let divDestinazione1 = quickstart.GestioneElementi.costruisciDrop(hiddenInput1);
            let divDestinazione2 = quickstart.GestioneElementi.costruisciDrop(hiddenInput2);
            let divDestinazione3 = quickstart.GestioneElementi.costruisciDrop(hiddenInput3);
            let divDestinazione4 = quickstart.GestioneElementi.costruisciDrop(hiddenInput4);
            let divDestinazione5 = quickstart.GestioneElementi.costruisciDrop(hiddenInput5);
            let divInputHidden = document.createElement("div");
            $(divInputHidden).append(hiddenInput1, hiddenInput2, hiddenInput3, hiddenInput4, hiddenInput5);
            $(form1).append(divInputHidden, quickstart.GestioneElementi.divEtichetta(richiesta), $(quickstart.GestioneElementi.divEtichetta(description)).css("margin", "3% 0%"), divDestinazione1, divDestinazione2, divDestinazione3, divDestinazione4, divDestinazione5, divSpazio, divPrimaLettera, divSecondaLettera, divTerzaLettera, divQuartaLettera, divQuintaLettera, $(quickstart.GestionePulsanti.costruisciNext()).css("margin-top", "23px"), quickstart.GestionePulsanti.costruisciRestart([divPrimaLettera, divSecondaLettera, divTerzaLettera, divQuartaLettera, divQuintaLettera], [divDestinazione1, divDestinazione2, divDestinazione3, divDestinazione4, divDestinazione5]), $(quickstart.GestioneLink.costruisciHome()).css("margin-top", "15px"));
            $(form2).append($(quickstart.GestionePulsanti.costruisciSkip()).css("margin-top", "22px"), quickstart.GestioneLink.costruisciLogout("4% 100%"));
            quickstart.Fabbrica.costruisciPagina(form1, form2);
        }
    }
    /**
     * Stringa che indica l'URL della servlet a cui si vogliono inviare i dati
     */
    MyAnnotation.SERVLET_URL = "myAnnotation.jsp";
    /**
     * Stringa che identifica il nome del task
     */
    MyAnnotation.TASK_NAME = "task=MY_ANNOTATION";
    quickstart.MyAnnotation = MyAnnotation;
    MyAnnotation["__class"] = "quickstart.MyAnnotation";
})(quickstart || (quickstart = {}));
quickstart.MyAnnotation.main(null);
