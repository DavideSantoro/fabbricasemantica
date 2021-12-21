/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    export class Logout {
        public static SERVLET_URL : string = "logout.jsp";

        public static main(args : string[]) {
            $.getJSON(Logout.SERVLET_URL);
        }
    }
    Logout["__class"] = "quickstart.Logout";

}


quickstart.Logout.main(null);
