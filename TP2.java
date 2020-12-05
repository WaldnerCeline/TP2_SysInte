 /**
 * Le but du TP est de trouver la valeur maximale associ�e � un nombre entier constitu�
 * de N bits. Par exemple, si mon entier est constitu� de 4 bits, sa valeur maximale est 15. S�il
 * est constitu� de 2 bits, la valeur maximale est 3, etc.
 *
 * Pour r�soudre ce probl�me, vous allez devoir g�n�rer une population de Y individus,
 * faire se reproduire les individus entre eux � l�aide du syst�me de la roulette afin de reg�n�rer
 * une nouvelle population de Y individus, puis recommencer et ce jusqu�� atteindre la
 * convergence. La d�tection de la convergence se fait visuellement.
 *
 *  Une fois cela fait, vous devrez impl�menter la s�lection par tournoi et, pour les plus
 * ambitieux, impl�menter la d�tection de la convergence et la mutation de g�ne. Pour rappel, la
 * mutation d�un g�ne correspond � un bit flip (0 -> 1 ou 1 -> 0). La convergence se calcule en
 * regardant la valeur maximale trouv�e � la fin d�une g�n�ration et en la comparant � la
 * g�n�ration pr�c�dente. Si trop de g�n�rations successives poss�dent la m�me valeur
 * maximale, c�est que la convergence a �t� atteinte.
 *
 * L�int�gralit� du code est document�e, libre � vous de vous baser dessus ou non. Le
 * choix du langage reste votre.
 */

public class TP2 {

    public static void main(String[] args)
    {
        int popSize = 50;
        int genesPerPop = 4;
       // Crosstype crosstype = Crosstype.ROULETTE;
        Crosstype crosstype = Crosstype.TOURNOI;
        float mutationChance = 0.05f;

        Population pop = new Population(popSize, genesPerPop, crosstype, mutationChance);

        System.out.println(pop);
        int convergeance = 0;

        //version avec epoch
        
        for(int epoch=0; epoch<50; epoch++)
        {
            Population newPop = pop.generateNewPopulation();
            pop = newPop;
        }
        

      /*  //version convergeance
        int cpt = 0;
        while (convergeance < 10)
        {
            Population newPop = pop.generateNewPopulation();
            int oldMaxFit = pop.getBestFiness();
            pop = newPop;
            int newMaxFit = pop.getBestFiness();
            if (oldMaxFit == newMaxFit)
                convergeance++;
            else
                convergeance = 0;
            cpt ++;
        }
        System.out.println("nb epoch : " + cpt);*/
        System.out.println(pop.toString());
    }
}
