import {Link} from "react-router-dom";
import "./searchItem.css";

const SearchItem = ({item}) => {
    return (
        <div className="searchItem">
            <img src={"http://localhost:8080/files/" + item.images[0]} alt="" className="siImg"/>
            <div className="siDesc">
                <h1 className="siTitle">{item.name}</h1>
                <span className="siDistance">{item.city.name}, {item.city.country}</span>
                <span className="siDistance">{item.address}</span>
                <span className="siTaxiOp">Безкоштовне таксі в межах міста</span>
                <span className="siTaxiOp">{item.rooms.length} номерів</span>
                <span className="siFeatures">{item.description}</span>
                <span className="siCancelOp">Безкоштовне скасування</span>
                <span className="siCancelOpSubtitle">
          Ви можете скасувати пізніше, тому зафіксуйте цю чудову ціну вже сьогодні!
        </span>
            </div>
            <div className="siDetails">
                {item.rating && <div className="siRating">
                    {item.rating === 5 && <span>Відмінно</span>}
                    {item.rating === 4 && <span>Добре</span>}
                    {item.rating === 3 && <span>Непогано</span>}
                    {item.rating > 3 && <span></span>}
                    <button>{item.rating}</button>
                </div>}
                <div className="siDetailTexts">
                    <span className="siPrice">${item.price}</span>
                    <span className="siTaxOp">Включає податки та збори</span>
                    <Link to={`/hotels/${item.id}`}>
                        <button className="siCheckButton">Переглянути наявність</button>
                    </Link>
                </div>
            </div>
        </div>
    );
};

export default SearchItem;
