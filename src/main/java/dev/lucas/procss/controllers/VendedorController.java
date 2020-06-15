package dev.lucas.procss.controllers;

import dev.lucas.procss.models.ObjetoFinal;
import dev.lucas.procss.models.Venda;
import dev.lucas.procss.models.Vendedor;
import dev.lucas.procss.repository.VendaRepository;
import dev.lucas.procss.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class VendedorController {

    @Autowired
    private VendedorRepository vendedorReposit;
    @Autowired
    private VendaRepository vendaReposit;


    @RequestMapping(value="/registrarVendedor", method = RequestMethod.GET)
    public String form(){

        return "vendas/registrarVendedor";
    }

    @RequestMapping(value="/registrarVendedor", method = RequestMethod.POST)
    public String form(Vendedor vendedor){
        vendedorReposit.save(vendedor);

        return "redirect:/registrarVendedor";
    }


    @RequestMapping("/selectVendedor")
    public ModelAndView listaVendedores(){
        ModelAndView mv = new ModelAndView("vendas/selectVendedor");
        Iterable<Vendedor> vendedores = vendedorReposit.findAll();
        mv.addObject("vendedores", vendedores);

        return mv;
    }

    @RequestMapping(value="/{idVendedor}", method=RequestMethod.GET)
    public ModelAndView filtrarVendedorGet(@PathVariable("idVendedor") long idVendedor){
        Vendedor vendedor = vendedorReposit.findByidVendedor(idVendedor);
        ModelAndView mv = new ModelAndView("vendas/realizarVenda");
        mv.addObject("vendedor", vendedor);

        return mv;
    }

    @RequestMapping(value="/{idVendedor}", method=RequestMethod.POST)
    public String filtrarVendedorPost(@PathVariable("idVendedor") long idVendedor, Venda venda){
        Vendedor vendedor = vendedorReposit.findByidVendedor(idVendedor);
        venda.setNomeVendedor(vendedor);
        vendaReposit.save(venda);

        return "redirect:/{idVendedor}";
    }

    @RequestMapping(value="/visaoGeral", method=RequestMethod.GET)
    public String visaoGeral(){

        return "vendas/visaoGeral";
    }

    @RequestMapping(value="/visaoGeral", method = RequestMethod.POST)
    public ModelAndView filtroVendedores(String inicio, String fim){
        ModelAndView mv = new ModelAndView("vendas/visaoFiltrada");

       /* Iterable<Vendedor> vendedor = vendedorReposit.findAll();
        mv.addObject("vendedor",vendedor);
        */

        Venda vendas = vendaReposit.findAllBydataVendaBetween(inicio, fim);
        mv.addObject("vendas", vendas);

        /*ObjetoFinal objetoFinal;
        objetoFinal.setNomeVendedor("Teste");
        objetoFinal.setTotalVendas(4);
        objetoFinal.setMediaDiaria(2);
        mv.addObject("objetoFinal", objetoFinal);*/
        return mv;
    }

}


/*
<div th:each="objetoFinal : ${objetoFinal}">
<p>Nome: <span th:text="${objetoFinal.nomeVendedor}" ></span></p>
<p>Total de vendas: <span th:text="${objetoFinal.totalVendas}"></span></p>
<p>Média de vendas diária: <span th:text="${objetoFinal.mediaDiaria}" ></span></p>
<p>-----------------------------------</p>
</div>

<div th:each="vendedor : ${vendedor}">
<p>Nome: <span th:text="${vendedor.nomeVendedor}" ></span></p>
<p>Total de vendas: <span th:text="${vendedor.nomeVendedor}"></span></p>
<p>Média de vendas diária: <span th:text="${vendedor.nomeVendedor}" ></span></p>
<p>-----------------------------------</p>
</div>

<div th:each="vendas : ${vendas}">
<p>Nome: <span th:text="${vendas.idVenda}" ></span></p>
<p>Total de vendas: <span th:text="${vendas.dataVenda}"></span></p>
<p>Média de vendas diária: <span th:text="${vendas.valorVenda}" ></span></p>
<p>-----------------------------------</p>
</div>
*/