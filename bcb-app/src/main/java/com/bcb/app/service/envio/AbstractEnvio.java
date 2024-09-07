package com.bcb.app.service.envio;

import com.bcb.app.domain.conta.Conta;
import com.bcb.app.domain.conta.ContaDto;
import com.bcb.app.domain.envio.EnvioDto;
import com.bcb.app.repository.envio.EnvioRepository;
import com.bcb.app.service.conta.ContaService;
import com.brestrai.utils.commons.service.AbstractService;
import com.twilio.Twilio;

public abstract class AbstractEnvio extends AbstractService {

    private final EnvioRepository envioRepository;

    private final ContaService contaService;

    protected static final String ACCOUNT_SID = "AC12775c5d9bf01757aa96dcb0b4908145";
    protected static final String AUTH_TOKEN = "aa14ac7920442fae3f805835a6f8e887";

    public AbstractEnvio(EnvioRepository envioRepository, ContaService contaService) {

        this.envioRepository = envioRepository;

        this.contaService = contaService;

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    public abstract void enviar(EnvioDto envioDto);

    protected void subtractBalance(EnvioDto envioDto) {

        ContaDto contaByCliente = contaService.findContaByCliente(envioDto.client());

        Conta conta = contaByCliente.toModel();

        conta.atualizarSaldo();

        contaService.update(conta);
    }
}
