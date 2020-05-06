import React, {Component} from 'react';
import Table from 'react-bootstrap/Table'
import {Badge} from "react-bootstrap";

class SensorTable extends Component {
    render() {
        return (

            <tr className='bg-info'>

                <td>{this.props.id}</td>

                <td className={this.props.status === '0'
                    ?
                    'td badge badge-pill badge-secondary'
                    :
                    this.props.status === '1' && this.props.co2Level <= 5 && this.props.smokeLevel <= 5
                        ?
                        'badge badge-pill badge-success'
                        :
                        'badge badge-pill badge-danger'
                } style={{
                    'justify-content': 'center',
                    'align-item': 'center'
                }}>
                    {this.props.status === "0"
                        ?
                        'Inactive'
                        : this.props ==="1" && this.props.co2Level > 5 || this.props.smokeLevel > 5
                        ?
                            'Warning'
                            :
                            'Active'

                    }

                </td>


                <td>{this.props.floorNumber}</td>

                <td>{this.props.roomNumber}</td>

                <td
                    className={this.props.status === '1' && this.props.smokeLevel <= 5
                        ?
                        'badge-success'
                        :
                        this.props.status === '1' && this.props.smokeLevel > 5
                            ?
                            'badge-danger'
                            :
                            'badge-secondary'
                    }

                >

                    {
                        this.props.status === '1'
                            ?
                            this.props.smokeLevel
                            :
                            'NA'}</td>
                <td
                    className={this.props.status === '1' && this.props.co2Level <= 5
                        ?
                        'badge-success'
                        :
                        this.props.status === '1' && this.props.co2Level > 5
                            ?
                            'badge-danger'
                            :
                            'badge-secondary'
                    }


                >{
                    this.props.status === '1'
                        ?
                        this.props.co2Level
                        :
                        'NA'}</td>
            </tr>


        );
    }
}

export default SensorTable;
