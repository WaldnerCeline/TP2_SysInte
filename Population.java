import jdk.jshell.spi.ExecutionControl;

import java.util.Arrays;
import java.lang.Math;

public class Population {

    private Individual[] individuals;
    private int genesPerPop;
    private Crosstype crosstype;
    private float mutationChance;

    /**
     * Representation of a population of pseudo-randomly generated individuals
     * @param popSize set the size of this population
     * @param genesPerPop sets the gene size of each individual in the pool
     * @param crosstype the crosstype to be used by this population
     * @param mutationChance chance for an individual to mutate at birth
     */
    public Population(int popSize, int genesPerPop, Crosstype crosstype, float mutationChance)
    {
        this.individuals = new Individual[popSize];
        this.genesPerPop = genesPerPop;
        this.crosstype = crosstype;
        this.mutationChance = mutationChance;
        for(int i=0; i<popSize; i++)
            this.individuals[i] = new Individual(genesPerPop);
    }

    /**
     * Representation of a population of pre-computed individuals
     * @param individuals an array of individuals
     * @param crosstype the crosstype to be used by this population
     * @param mutationChance chance for an individual to mutate at birth
     */
    public Population(Individual[] individuals, Crosstype crosstype, float mutationChance)
    {
        assert individuals.length > 0;
        this.individuals = individuals;
        this.genesPerPop = individuals[0].getGenes().length;
        this.crosstype = crosstype;
        this.mutationChance = mutationChance;
    }

    /**
     * Creates a new population using this generation's individuals
     * @return the newly generated population
     */
    public Population generateNewPopulation()
    {
        //Utilisez les CROSSTYPE ici pour différencier le type de sélection

        if(this.crosstype == Crosstype.ROULETTE)
        {
            System.out.println("ha");
            //ToDo generate using a ROULETTE crosstype
            /*
            for (int i = 0 ; i < individuals.length; i++)
            {
                Individual parent1 = roulette(individuals);
                Individual parent2 = roulette(individuals);
                Individual[] tab = croisement1Point(parent1, parent2);

            }
            */


        }
        else{
            //ToDo generate using a TOURNOI crosstype
        }
    }

    private Individual roulette(Individual[] population)
    {
        int somme = 0;
        for (int i = 0; i < population.length; i++)
        {
            somme += population[i].getFitnessScore();
        }
        double alea = Math.random() * somme;
        int cummul = 0;
        int index = 0;
        while(cummul + population[index].getFitnessScore() < alea)
        {
            cummul += population[index].getFitnessScore();
            index += 1;
        }
        return population[index];
    }
    private Individual[] croisement1Point (Individual parent1, Individual parent2)
    {
        int xp = 2;
        int[] enfant1 = new int[parent1.getGenes().length];
        int[] enfant2 = new int[parent1.getGenes().length];

        for (int i = 0; i < xp; i++){
            enfant1[i] = parent1.getGenes()[i];
            enfant2[i] = parent2.getGenes()[i];
        }
        for (int i = xp; i < parent1.getGenes().length; i++){
            enfant1[i] = parent2.getGenes()[i];
            enfant2[i] = parent1.getGenes()[i];
        }
        Individual[] tab = new Individual[2];
        tab[0] = new Individual(enfant1);
        tab[1] = new Individual(enfant2);
        return tab;
    }

    /**
     * Takes 2 individuals and create 2 children using their genes
     * @param firstParent the first selected individual
     * @param secondParent the second selected individual
     * @param crosspoint index of the crosspoint
     * @return an array of 2 individuals
     */
    public Individual[] reproduceIndividuals(Individual firstParent, Individual secondParent, int crosspoint)
            throws ExecutionControl.NotImplementedException
    {
        Individual[] offsprings = new Individual[2];

//        int[] firstChildGenes = new int[genesPerPop];
//        int[] secondChildGenes = new int[genesPerPop];
//        ToDo compute the genes
//        ToDo compute a possible mutation of a gene
//        offsprings[0] = new Individual(firstChildGenes);
//        offsprings[1] = new Individual(secondChildGenes);

        throw new ExecutionControl.NotImplementedException("Method reproduceIndividuals has not been implemented yet.");
    }

    @Override
    public String toString()
    {
        return "Population{" +
                "individuals=" + Arrays.toString(individuals) +
                ", genesPerPop=" + genesPerPop +
                '}';
    }
}

