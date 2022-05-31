import useFetch from "../../hooks/useFetch";
import "./featuredProperties.css";
import {useEffect, useState} from "react";
import {Link} from "react-router-dom";

const FeaturedProperties = () => {

    const {data, loading, error} = useFetch("/hotels");
    const [number, setNumber] = useState(0);

    useEffect(() => {
        if (data) {
            if (data && data.length >= 9) {
                setNumber(9);
            } else {
                setNumber(data.length);
            }
        }
    }, [data]);

    return (
        <div className="fp">
            {loading ? (
                "Loading"
            ) : (
                <div style={{display: "flex", flexWrap: "wrap"}}>
                    {data.slice(0, number).map((item) => (
                        <div className="fpItem" key={item.id}>
                            {
                                item.images &&
                                <Link to={`/hotels/${item.id}`} style={{textDecoration: "none"}}>
                                    <img
                                        src={"http://localhost:8080/files/" + item.images[0]}
                                        alt={item.name}
                                        className="fpImg"
                                    />
                                </Link>
                            }
                            <Link to={`/hotels/${item.id}`} style={{textDecoration: "none"}}>
                                <span className="fpName">{item.name}</span>
                            </Link>
                            <span className="fpCity">{item.city.name}, {item.city.country}</span>
                            <span className="fpPrice">Від ${item.price}</span>
                            {item.rating && <div className="fpRating">
                                <button>{item.rating}</button>
                                {item.rating == 5 && <span>Відмінно</span>}
                                {item.rating == 4 && <span>Добре</span>}
                                {item.rating == 3 && <span>Не погано</span>}
                            </div>}
                        </div>
                    ))}
                </div>
            )}
        </div>
    );
};

export default FeaturedProperties;
