import React from 'react'
import {withRouter} from 'react-router-dom'
import {Button, Dialog, Heading, Pane} from 'evergreen-ui'
import MaquinaService from '../api/MaquinaService'
import Log from '../components/Log'

class Home extends React.Component {
    constructor(props){
        super(props);

        this.state = {
            maquinas : [],
            mqSelecionada:{id:0, nome:""},
            dialogShow:false
        }

        this.maquinaService = new MaquinaService();
    }

    render() {
        return (
        <Pane paddingX="5em">
            <Dialog
                isShown={this.state.dialogShow}
                title={this.state.mqSelecionada.nome}
                onCloseComplete={()=>this.setState({maquinas:this.state.maquinas, dialogShow:false, mqSelecionada:this.state.mqSelecionada})}
                hasFooter={false}>
                    {
                        ({close})=> (
                            <Log idMaquina = {this.state.mqSelecionada.id} nomeMaquina = {this.state.mqSelecionada.nome} close={close}>
                            </Log>
                        )
                    }
            </Dialog>
            {
                this.state.maquinas.map((maq, idx) => {
                    return (
                        <Pane width="100%">
                            <Heading>{maq.nome}</Heading>
                            <Button appearance="primary" intent="success" onClick={()=>this.setState({maquinas:this.state.maquinas, dialogShow:true, mqSelecionada:maq})}>Log</Button>
                        </Pane>
                    )
                })
            }
        </Pane>
        )
    }

    componentDidMount(){
        this.maquinaService.get("").then((res)=>{
            this.setState({maquinas : res.data});
        }).catch((err)=>{
            this.setState({maquinas : []});
        })
    }
}

export default withRouter(Home)