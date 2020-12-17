import React from 'react'
import { withRouter } from 'react-router'
import {
    Pane,
    Table,
    Text
} from 'evergreen-ui'
import LogService from '../api/LogService';

class Log extends React.Component {

    constructor(props){
        super(props);
        this.state = {
            logs:[]
        }

        this.logService = new LogService();
    }

    render () {
        return (
            <Pane>
                {
                    this.state.logs.length > 0 &&
                    <Table>
                        <Table.Head>
                            <Table.TextHeaderCell flex={3}>
                                Data
                            </Table.TextHeaderCell>
                            <Table.TextHeaderCell>
                                CPU (%)
                            </Table.TextHeaderCell>

                            <Table.TextHeaderCell>
                                GPU (%)
                            </Table.TextHeaderCell>

                            <Table.TextHeaderCell>
                                MEM (%)
                            </Table.TextHeaderCell>

                            <Table.TextHeaderCell>
                                DISCO (%)
                            </Table.TextHeaderCell>
                        </Table.Head>
                        <Table.Body>
                            {
                                this.state.logs.map((log, idx)=>{
                                    console.log(log);
                                    let date = new Date(log.data[0], log.data[1] - 1, log.data[2], log.data[3], log.data[4], log.data[5]);

                                    return (
                                        <Table.Row key={log.id}>
                                            <Table.TextCell flex={3}>{ date.toLocaleString()}</Table.TextCell>
                                            <Table.TextCell>{log.consumoCpu}</Table.TextCell>
                                            <Table.TextCell>{log.consumoGpu}</Table.TextCell>
                                            <Table.TextCell>{log.consumoMemoria}</Table.TextCell>
                                            <Table.TextCell>{log.consumoDisco}</Table.TextCell>
                                        </Table.Row>
                                    )
                                })
                            }
                        </Table.Body>
                    </Table>
                }

                {
                    this.state.logs.length <= 0 &&
                    <Pane>
                        <Text>Não existem logs cadastrados</Text>
                    </Pane>
                }
            </Pane>
        )
    }

    componentDidMount(){
        this.logService.get("/" + this.props.idMaquina).then((res) => {
            this.setState({logs: res.data });
        }).catch((err)=>{
            this.setState({logs: [] });
        });
    }
}
export default withRouter(Log)