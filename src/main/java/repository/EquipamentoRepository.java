package repository;

import model.Equipamento;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EquipamentoRepository {

    // Lista estática para manter os dados enquanto o programa estiver aberto
    private static List<Equipamento> bancoDeDadosEquipamentos = new ArrayList<>();

    public EquipamentoRepository() {
        // --- DATA SEEDING: Cadastra itens automaticamente ao iniciar ---
        if (bancoDeDadosEquipamentos.isEmpty()) {
            System.out.println("Semeando banco de dados de equipamentos...");
            
            salvar(new Equipamento("Bola Oficial", "Esporte", 20, 15, Equipamento.Condicao.DISPONIVEL, 20));
            salvar(new Equipamento("Chuteira Nike", "Calcado", 10, 25, Equipamento.Condicao.DISPONIVEL, 10));
            salvar(new Equipamento("Colete Treino", "Acessorio", 50, 5, Equipamento.Condicao.DISPONIVEL, 50));
            salvar(new Equipamento("Raquete Tênis", "Esporte", 5, 40, Equipamento.Condicao.DISPONIVEL, 5));
            salvar(new Equipamento("Rede Vôlei", "Acessorio", 2, 100, Equipamento.Condicao.DISPONIVEL, 2));
        }
    }

    public void salvar(Equipamento equipamento) {
        bancoDeDadosEquipamentos.add(equipamento);
    }

    public List<Equipamento> listarTodos() {
        return new ArrayList<>(bancoDeDadosEquipamentos);
    }

    public Optional<Equipamento> buscarPorNome(String nome) {
        return bancoDeDadosEquipamentos.stream()
                .filter(e -> e.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }
}
