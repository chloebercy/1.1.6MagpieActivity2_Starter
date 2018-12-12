/**
 * A program to carry on conversations with a human user.
 * This version:
 *<ul><li>
 *      Uses advanced search for keywords 
 *</li><li>
 *      Will transform statements as well as react to keywords
 *</li></ul>
 * @author Laurie White
 * @version April 2012
 *
 */
public class Magpie4
{
    /**
     * Get a default greeting   
     * @return a greeting
     */ 
    public String getGreeting()
    {
        return "Hello. For a restaurant recommendation, please indicate a type of cusine and a location within Singapore (Orchard, Somerset, Marina Bay, Esplanade, Sentosa)";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        if (statement.length() == 0)
        {
            response = "Please indicate a type of cusine and a location within Singapore or reply \"Bye\" to close this conversation";
        }

        else if (findKeyword(statement, "don't know") >= 0
                 || findKeyword(statement, "not sure") >= 0
                 || findKeyword(statement, "no idea") >= 0
                 || findKeyword(statement, "don't care") >= 0
                 || findKeyword(statement, "don't mind") >= 0)
        {
            response = transformIndecisive(statement);;
        }
        
        else if (findKeyword(statement, "no") >= 0
                 || findKeyword(statement, "don't") >= 0
                 || findKeyword(statement, "not") >= 0
                 )
        {
            if (findKeyword(statement, "random") >= 0){
                response = "Don't ask for a random recommendation if you are picky.";
            } else if (findKeyword(statement, "anything") >=0){
                response = "Don't ask for anything if you are picky";
            }else {
                response = "Please don’t tell me what you don’t want, tell me what do you want to eat";
            }
        }
        
        else if (findKeyword(statement, "sushi") >= 0)
        {
            
            if (findKeyword(statement, "somerset") >= 0){
                response = "Sakae Sushi- 2727 Morris Ave, Union, NJ 07083";
            } else if (findKeyword(statement, "marina bay") >= 0){
                response = "Standing Sushi Bar-  8A Marina Boulevard, #B2-51, Marina Bay Link Mall, Singapore 018984";
            } else if (findKeyword(statement, "sentosa") >= 0){
                response = "Syun-  26 Sentosa Gateway, Festive Walk, #02-135 & 135A, Singapore 098138";
            } else if (findKeyword(statement, "esplanade") >= 0){
                response = "Sushi Express @ CityLink Mall- 1 Raffles Link, #B1-23 CityLink Mall, Singapore 039393";
            } else {
                response = "The Sushi Bar 391B Orchard Road, #05-34/35, Ngee Ann City, Singapore 238874";
            }
        } 
        else if (findKeyword(statement, "ramen") >= 0) 
        {
            if (findKeyword(statement, "somerset") >= 0){
                response = "Hokkaido Ramen Santouka- 35 Cuppage Rd, Singapore 229459";
            } else if (findKeyword(statement, "marina bay") >= 0){
                response = "IPPUDO Marina Bay Sands- 2 Bayfront Avenue, #B2-54/55, The Shoppes at Marina Bay Sands, Singapore 018972";
            } else if (findKeyword(statement, "sentosa") >= 0){
                response = "Ramen Hitoyoshi- 1 Maritime Square, #01-99, Harbourfront Centre, Singapore 099253";
            } else if (findKeyword(statement, "esplanade") >= 0){
                response = "Uma Uma- #02-06 Millenia Walk,, 9 Raffles Blvd, Singapore 039596";
            } else {
                response = "Sanpoutei Ramen, Shaw House- 350 Orchard Rd Singapore, #B1-04/05, Singapore 238868";
            }
        }
        else if (findKeyword(statement, "any japanese") >= 0) 
        {
            if (findKeyword(statement, "somerset") >= 0){
                response = "YAYOIKEN 313@somerset- 313 Orchard Rd, #B3-33/34, Singapore 238895";
            } else if (findKeyword(statement, "marina bay") >= 0){
                response = "Sen of Japan- 10 Bayfront Ave, #01-86 Marina Bay Sands Shoppes, Singapore 018972";
            } else if (findKeyword(statement, "sentosa") >= 0){
                response = "Syun- 26 Sentosa Gateway, Festive Walk, #02-135 & 135A, Singapore 098138";
            } else if (findKeyword(statement, "esplanade") >= 0){
                response = "Tomo Izakaya Japanese Restaurant- 8 Raffles Ave, 01-09, Singapore 039802";
            } else {
                response = "Suju Japanese Restaurant- No. 333A, Orchard Road, #04-05, Mandarin Gallery Singapore, 238897, Singapore 238897";
            } 
            
        }
        else if (findKeyword(statement, "japanese") >= 0)
        {
            response = "Is there any specific Japanese food you want? (choose:sushi/ramen/any japanese food)";
        }
        else if (findKeyword(statement, "korean bbq") >= 0) 
        {
            
            if (findKeyword(statement, "somerset") >= 0){
                response = "Masizzim 313@Somerset- 313 Orchard Rd, #B3-02, Singapore 238895";
            } else if (findKeyword(statement, "marina bay") >= 0){
                response = "Guiga Korean BBQ Restaurant- 134 Tg Pagar Rd, Singapore 088538";
            } else if (findKeyword(statement, "sentosa") >= 0){
                response = "Ju Shin Jung Korean Barbecue- ";
            } else if (findKeyword(statement, "esplanade") >= 0){
                response = "Seorae Korean Charcoal BBQ (Plaza Singapura)- 68 Orchard Rd, #02-01, Plaza Singapura, Singapore 238839";
            } else {
                response = "8 Korean BBQ (Shaw Centre)- 1 Scotts Rd, #04-20/21, Singapore 228208";
            } 
            
        }
        else if (findKeyword(statement, "any korean") >= 0) 
        {
             
            if (findKeyword(statement, "somerset") >= 0){
                response = "Daessiksin Korean BBQ Buffet- 277 Orchard Road, Orchard Gateway, #03-17, Singapore 238858";
            } else if (findKeyword(statement, "marina bay") >= 0){
                response = "Hyang To Gol Restaurant- 165 Tanjong Pagar Rd, Singapore 088539";
            } else if (findKeyword(statement, "sentosa") >= 0){
                response = "Bornga Singapore @ VivoCity- 1 Harbourfront Walk, Vivocity, #02-123, Singapore 098585";
            } else if (findKeyword(statement, "esplanade") >= 0){
                response = "Manna Korean Restaurant- 101-109 Telok Ayer St, Singapore 068574";
            } else {
                response = "K.Cook- 181 Orchard Road, #07-01, Singapore 238896";
            } 
            
        }
        else if (findKeyword(statement, "korean") >= 0)
        {
            response = "Is there any specific Korean food you want? (choose:korean bbq/any korean food)";
        }
        else if (findKeyword(statement, "taiwanese") >= 0
                ||findKeyword(statement, "dim sum") >= 0
                ||findKeyword(statement, "dimsum") >= 0)
        {
            if (findKeyword(statement, "somerset") >= 0){
                response = "Din Tai Fung- 176 Orchard Rd, #02-55 The Centrepoint, Singapore 238843";
            } else if (findKeyword(statement, "marina bay") >= 0){
                response = "Din Tai Fung- The Shoppes At Marina Bay Sands Canal Level, #B1-01, 2 Bayfront Ave, Singapore 018972";
            } else if (findKeyword(statement, "sentosa") >= 0){
                response = "Din Tai Fung- 26 Sentosa Gateway, #01-217 Resorts World Sentosa, Singapore 098138";
            } else if (findKeyword(statement, "esplanade") >= 0){
                response = "Din Tai Fung- 3 Temasek Blvd, #02-302 Suntec City, Singapore 038983";
            } else {
                response = "Din Tai Fung- Wisma Atria, 435 Orchard Rd, level 4, Singapore 238877";
            } 
        }
        else if (findKeyword(statement, "spanish") >= 0)
        {
            if (findKeyword(statement, "somerset") >= 0){
                response = "Tapas Club Orchard Central- 181 Orchard Road, #02-13 Orchard Central";
            } else if (findKeyword(statement, "marina bay") >= 0){
                response = "OLA Cocina Del Mar- 12 Marina Blvd, 01 -06, Singapore 018981";
            } else if (findKeyword(statement, "sentosa") >= 0){
                response = "FOC Sentosa- 110 Tanjong Beach Walk, Singapore 098943";
            } else if (findKeyword(statement, "esplanade") >= 0){
                response = "My Little Tapas Bar- 14 Ann Siang Rd, Singapore 069694";
            } else {
                response = "Tapas Club Orchard Central- 181 Orchard Road, #02-13 Orchard Central";
            } 
        }
        else if (findKeyword(statement, "thai") >= 0)
        {
            if (findKeyword(statement, "somerset") >= 0){
                response = "Som Tam- 181 Orchard Rd, 08-13, Singapore 238896";
            } else if (findKeyword(statement, "marina bay") >= 0){
                response = "Long Chim- 10 Bayfront Avenue, #02-02, Atrium 2 The Shoppes at Marina Bay Sands, Singapore 018955";
            } else if (findKeyword(statement, "sentosa") >= 0){
                response = "Bali Thai- 26 Sentosa Gateway, #B1-221 Resorts World Sentosa, Singapore 098138";
            } else if (findKeyword(statement, "esplanade") >= 0){
                response = "ThaiExpress- 252 North Bridge Rd, #B1-77, Singapore 179103";
            } else {
                response = "Nara Thai Cuisine- 2 Orchard Turn, #B3-21,ION Orchard, Singapore 238801";
            } 
        }
        else if (findKeyword(statement, "french") >= 0)
        {
            if (findKeyword(statement, "somerset") >= 0){
                response = "Le Pin Wine Bar- 150 Orchard Rd, #02-16 Orchard Plaza, Singapore 238841";
            } else if (findKeyword(statement, "marina bay") >= 0){
                response = "db Bistro- 2 Bayfront Avenue, B1-48, Galleria Level, The Shoppes at Marina Bay Sands, Singapore 018956";
            } else if (findKeyword(statement, "sentosa") >= 0){
                response = "Poulét- 1 Harbourfront Walk #01-175/176/177, Singapore 098585";
            } else if (findKeyword(statement, "esplanade") >= 0){
                response = "Gunther's Modern French Cuisine- 36 Purvis Street #01-03, Singapore 188613";
            } else {
                response = "Bistro Du Vin- 1 Scotts Rd, #01-14 Shaw Centre, Singapore 228208";
            } 
        }
        else if (findKeyword(statement, "italian") >= 0)
        {
            if (findKeyword(statement, "somerset") >= 0){
                response = "Trattoria Italian Kitchen- 313 Orchard Road, 313@Somerset #01-16, Singapore 238895";
            } else if (findKeyword(statement, "marina bay") >= 0){
                response = "Dolce Vita- 5 Raffles Ave, Singapore 039797";
            } else if (findKeyword(statement, "sentosa") >= 0){
                response = "Fratelli Trattoria- 26 Sentosa Gateway, Hotel Michael, #02-144 & 145, Singapore 098138";
            } else if (findKeyword(statement, "esplanade") >= 0){
                response = "Supply & Demand, Esplanade- 8 Raffles Avenue, #01-13 Esplanade Mall, Singapore 039802";
            } else {
                response = "Modesto's @ Orchard- 1 Tanglin Rd, #01-09/10 Rendezvous Hotel, Singapore 247905";
            } 
        }
        else if (findKeyword(statement, "mexican") >= 0)
        {
            if (findKeyword(statement, "somerset") >= 0){
                response = "Barrio by Mex Out, 313@Somerset- 313@Somerset #01-14/15, 313 Orchard Rd, Singapore";
            } else if (findKeyword(statement, "marina bay") >= 0){
                response = "Super Loco Customs House- 70 Collyer Quay, #01-04, Singapore 049323";
            } else if (findKeyword(statement, "sentosa") >= 0){
                response = "TWO CHEFS BAR MEXICAN & ITALIAN- 31 Ocean Way, #01-11 Quayside Isle, Singapore 098375";
            } else if (findKeyword(statement, "esplanade") >= 0){
                response = "Vatos, Esplanade- 36 Beach Rd, Singapore 189766";
            } else {
                response = "Muchos- 60 Orchard Rd, Singapore 238889";
            } 
        }
        else if (findKeyword(statement, "greek") >= 0)
        {
            if (findKeyword(statement, "somerset") >= 0){
                response = "BAKALAKI Greek Taverna- 3 Seng Poh Rd, Singapore 168891";
            } else if (findKeyword(statement, "marina bay") >= 0){
                response = "Pita & Olives- 7 Temasek Blvd, Singapore 038987";
            } else if (findKeyword(statement, "sentosa") >= 0){
                response = "Mykonos On The Bay- 31 Ocean Way, 01-10, Singapore 098375";
            } else if (findKeyword(statement, "esplanade") >= 0){
                response = "BAKALAKI Greek Taverna- 3 Seng Poh Rd, Singapore 168891";
            } else {
                response = "Blu Kouzina- #01, 10 Dempsey Rd, 21, Singapore 247700";
            } 
        }
        else if (findKeyword(statement, "indian") >= 0
                 || findKeyword(statement, "vegetarian") >=0)
        {
            if (findKeyword(statement, "somerset") >= 0){
                response = "The Curry Culture- 31 Cuppage Road, Cuppage Terrace, Singapore 229457";
            } else if (findKeyword(statement, "marina bay") >= 0){
                response = "Rang Mahal- 7 Raffles Boulevard, Level 3, Pan Pacific Singapore, Singapore 039595";
            } else if (findKeyword(statement, "sentosa") >= 0){
                response = "Earl Of Hindh- 31 Ocean Way, #01-16, Singapore 098375";
            } else if (findKeyword(statement, "esplanade") >= 0){
                response = "Gajalee- 8 Raffles Ave, Esplanade Mall, Singapore 039802";
            } else {
                response = "Tandoor- 11 Cavenagh Rd, Singapore 229616";
            } 
        }
        else
        {
           response = getRandomResponse();
        }
        return response;
    }

        
    /**
     * Take a statement with the meaning "I don't know <something>." and transform it into 
     * "If you don't know <something>, ask for a random recommendation?"
     * Assumes <something> is a "what to eat"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    private String transformIndecisive(String statement)
    {
        //  Remove the final period, if there is one
        String phrase;
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
                }
        if (findKeyword(statement, "don't know") >= 0){
            phrase = "don't know"; 
        } else if (findKeyword(statement, "not sure") >= 0){
            phrase = "not sure";
        } else if (findKeyword(statement, "no idea") >= 0){
            phrase = "no idea";
        } else if (findKeyword(statement, "don't care") >= 0){
            phrase = "don't care";
        } else if (findKeyword(statement, "don't mind") >= 0){
            phrase = "don't mind";
        } else{
            phrase = "don't have a preferrence";
        }
        
        int psn = findKeyword (statement, phrase, 0) + 1;
        
        if (phrase.equals("don't know")){
            String restOfStatement = statement.substring(psn + phrase.length()).trim();
            return "If you " + phrase + restOfStatement + ", ask for a: \"random recommendation\"!";
        } else if (phrase.equals("not sure")){
            return "If you are " + phrase + ", ask for a: \"random recommendation\"!";
        } else if (phrase.equals("no idea")){
            return "If you have " + phrase + ", ask for a: \"random recommendation\"!";
        }
        else{
            return "If you " + phrase + ", ask for a: \"random recommendation\"!";
        }
        
    }
  
    
    /**
     * Search for one word in phrase.  The search is not case sensitive.
     * This method will check that the given goal is not a substring of a longer string
     * (so, for example, "I know" does not contain "no").  
     * @param statement the string to search
     * @param goal the string to search for
     * @param startPos the character of the string to begin the search at
     * @return the index of the first occurrence of goal in statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal, int startPos)
    {
        String phrase = statement.trim();
        //  The only change to incorporate the startPos is in the line below
        int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
        
        //  Refinement--make sure the goal isn't part of a word 
        while (psn >= 0) 
        {
            //  Find the string of length 1 before and after the word
            String before = " ", after = " "; 
            if (psn > 0)
            {
                before = phrase.substring (psn - 1, psn).toLowerCase();
            }
            if (psn + goal.length() < phrase.length())
            {
                after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
            }
            
            //  If before and after aren't letters, we've found the word
            if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))  //  before is not a letter
                    && ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
            {
                return psn;
            }
            
            //  The last position didn't work, so let's find the next, if there is one.
            psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
            
        }
        
        return -1;
    }
    
    /**
     * Search for one word in phrase.  The search is not case sensitive.
     * This method will check that the given goal is not a substring of a longer string
     * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
     * @param statement the string to search
     * @param goal the string to search for
     * @return the index of the first occurrence of goal in statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal)
    {
        return findKeyword (statement, goal, 0);
    }
    


    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 4;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Sorry, I couldn't find a recommendation. Are you talking about something else?";
        }
        else if (whichResponse == 1)
        {
            response = "Sorry, no result matches your search. Please try again.";
        }
        else if (whichResponse == 2)
        {
            response = "I don't understand what you are saying. Sorry, try entering a type of cusine or location in Singapore";
        }
        else if (whichResponse == 3)
        {
            response = "Nothing came up with your search. This is a Singapore restaurant recommendation chatbot, use accordingly.";
        }

        return response;

     }
    }
