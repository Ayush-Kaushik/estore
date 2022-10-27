import React, { useState, useEffect } from 'react';
import { useTable } from 'react-table'

function Home() {

    const [data, setData] = useState([]);

    const columns = React.useMemo(
        () => [
            {
                Header: 'ID',
                accessor: 'ID',
            },
            {
                Header: 'Product Code',
                accessor: 'ProductCode',
            },
            {
                Header: 'Name',
                accessor: 'Name',
            },
            {
                Header: 'Barcode',
                accessor: 'Barcode',
            },
            {
                Header: 'Description',
                accessor: 'Description',
            },
            {
                Header: 'Image',
                accessor: 'ProductImageUrl',
            },
            {
                Header: 'Price',
                accessor: 'Price',
            },
        ],
        []
    );

    async function populateProductData() {
        const response = await fetch('api/product');
        const data = await response.json();
        setData(data);
    }

    useEffect(() => {
        populateProductData();
    }, [data]);

    const {
        getTableProps,
        getTableBodyProps,
        headerGroups,
        rows,
        prepareRow,
    } = useTable({ columns, data })

    return (
        <table {...getTableProps()} style={{ border: 'solid 1px blue' }}>
            <thead>
                {headerGroups.map(headerGroup => (
                    <tr {...headerGroup.getHeaderGroupProps()}>
                        {headerGroup.headers.map(column => (
                            <th
                                {...column.getHeaderProps()}
                                style={{
                                    borderBottom: 'solid 3px red',
                                    background: 'aliceblue',
                                    color: 'black',
                                    fontWeight: 'bold',
                                }}
                            >
                                {column.render('Header')}
                            </th>
                        ))}
                    </tr>
                ))}
            </thead>
            <tbody {...getTableBodyProps()}>
                {rows.map(row => {
                    prepareRow(row)
                    return (
                        <tr {...row.getRowProps()}>
                            {row.cells.map(cell => {
                                return (
                                    <td
                                        {...cell.getCellProps()}
                                        style={{
                                            padding: '10px',
                                            border: 'solid 1px gray',
                                            background: 'papayawhip',
                                        }}
                                    >
                                        {cell.render('Cell')}
                                    </td>
                                )
                            })}
                        </tr>
                    )
                })}
            </tbody>
        </table>
    );
}

export default Home;
