#include <iostream>
#ifdef WIN32
    #include <windows.h>
#else
    #include <unistd.h>
#endif

#include <cstdlib>
#include <ctime>

# include <iomanip>
# include <mpi.h>

void printOut(int index, time_t date, std::string user, double value)
{
    std::cout << index << ' ' << date << ' ' << user << ' ' << value << std::endl;
}

void sleepcp(int milliseconds) // Cross-platform sleep function
{
    #ifdef WIN32
        Sleep(milliseconds);
    #else
        usleep(milliseconds * 1000);
    #endif
}

int main(int argc, char** argv) {
    // Initialize the MPI environment
    MPI_Init(NULL, NULL);

    // Get the number of processes
    int world_size;
    MPI_Comm_size(MPI_COMM_WORLD, &world_size);

    // Get the rank of the process
    int world_rank;
    MPI_Comm_rank(MPI_COMM_WORLD, &world_rank);

    // Get the name of the processor
    char processor_name[MPI_MAX_PROCESSOR_NAME];
    int name_len;
    MPI_Get_processor_name(processor_name, &name_len);

    // Print off a hello world message
    printf("Hello world from processor %s, rank %d out of %d processors\n", processor_name, world_rank, world_size);

    // use a different seed for the random generator 
    unsigned int seed = 1 + world_rank;
    //std::cout << "Seed: " << seed << std::endl;
    std::srand(seed);
    int index;

    std::string users[] = { "Pippo", "Pluto", "Paperino", "Minnie", "Paperina" };
    while(true){
        int n = std::rand();
        int sleepTime = n % 4000 + 1000; // rand() return a number between ​1000​ and 5000
        int userIndex = n % 5;
        //std::cout << sleepTime << " " << userIndex << std::endl;
        std::string user = users[userIndex];
        double value = n % 1000 / (double)1000;
        std::time_t currentTime = std::time(NULL);
        printOut(index++, currentTime, user, value);
        sleepcp(sleepTime);
    }

    // Finalize the MPI environment.
    MPI_Finalize();
    
}