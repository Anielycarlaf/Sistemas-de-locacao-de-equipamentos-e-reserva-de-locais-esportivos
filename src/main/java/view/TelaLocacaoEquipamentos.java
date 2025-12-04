package repository;

import model.LocalEsportivo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LocalEsportivoRepository {

    private static List<LocalEsportivo> bancoDeDadosLocais = new ArrayList<>();

    public LocalEsportivoRepository() {
        // --- DATA SEEDING ---
        if (bancoDeDadosLocais.isEmpty()) {
            System.out.println("Semeando banco de dados de locais...");
            
            salvar(new LocalEsportivo("Quadra Poliesportiva A", "Quadra", 20, 100.0, LocalEsportivo.Condicao.DISPONIVEL, new ArrayList<>()));
            salvar(new LocalEsportivo("Campo Society 1", "Campo", 30, 250.0, LocalEsportivo.Condicao.DISPONIVEL, new ArrayList<>()));
            salvar(new LocalEsportivo("Quadra de Tênis", "Quadra", 4, 150.0, LocalEsportivo.Condicao.DISPONIVEL, new ArrayList<>()));
        }
    }

    public void salvar(LocalEsportivo local) {
        bancoDeDadosLocais.add(local);
    }

    public List<LocalEsportivo> listarTodos() {
        return new ArrayList<>(bancoDeDadosLocais);
    }
    
    public Optional<LocalEsportivo> buscarPorNome(String nome) {
        return bancoDeDadosLocais.stream()
                .filter(l -> l.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }
}
